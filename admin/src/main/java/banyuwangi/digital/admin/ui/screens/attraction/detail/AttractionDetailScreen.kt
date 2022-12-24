package banyuwangi.digital.admin.ui.screens.attraction.detail

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import banyuwangi.digital.admin.R
import banyuwangi.digital.admin.ui.components.*
import banyuwangi.digital.admin.ui.theme.TamansariTheme
import banyuwangi.digital.admin.ui.theme.grey200
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.launch
import org.apache.commons.io.FileUtils
import org.koin.androidx.compose.koinViewModel
import java.io.File


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AttractionDetailScreen(
    attraction: WisataDomain?,
    navController: NavController,
    viewModel: AttractionDetailViewModel = koinViewModel()
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopBar(
                title = attraction?.name ?: "",
                buttonIcon = Icons.Filled.ArrowBack,
                onButtonClicked = { navController.popBackStack() }
            )
        },
        content = {
            val bottomSheetState =
                rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            val coroutineScope = rememberCoroutineScope()
            var bottomSheetContent: (@Composable () -> Unit)? by remember {
                mutableStateOf(null)
            }

            var openDialog by remember { mutableStateOf(false) }

            if (openDialog) {
                SimpleAlertDialog(
                    onDismiss = { openDialog = false },
                    item = viewModel.selectedTicket.name,
                    onConfirm = { id ->
                        viewModel.deleteTicket(attraction?.id ?: "", id)
                        openDialog = false
                    },
                    itemId = viewModel.selectedTicket.id
                )
            }

            DefaultModalBottomSheetDialog(
                bottomSheetState = bottomSheetState,
                sheetContent = {
                    Box(
                        modifier = Modifier.defaultMinSize(minHeight = 1.dp)
                    ) {
                        bottomSheetContent?.let { it() }
                    }
                },
                content = {
                    AttractionDetailContent(
                        attraction = attraction,
                        viewModel = viewModel,
                        onAddTicket = {
                            viewModel.updateSelectedTicket("", "", "0")
                            bottomSheetContent = {
                                AddAttractionTicketBottomSheetContent(
                                    onSubmit = {
                                        attraction?.id?.let { idWisata ->
                                            viewModel.addTicket(
                                                idWisata
                                            )
                                        }
                                        coroutineScope.launch {
                                            bottomSheetState.hide()
                                        }
                                    },
                                    initialName = viewModel.selectedTicket.name,
                                    initialPrice = viewModel.selectedTicket.price.toString(),
                                    onNameChange = { name ->
                                        viewModel.updateTicketName(name)
                                    },
                                    onPriceChange = { price ->
                                        viewModel.updateTicketPrice(price)
                                    },
                                    title = stringResource(id = R.string.add_ticket)
                                )
                            }
                            coroutineScope.launch {
                                bottomSheetState.show()
                            }
                        },
                        onUpdateTicket = { _id, _name, _price ->
                            viewModel.updateSelectedTicket(_id, _name, _price)
                            bottomSheetContent = {
                                AddAttractionTicketBottomSheetContent(
                                    onSubmit = {
                                        attraction?.id?.let { idWisata ->
                                            viewModel.editTicket(
                                                idWisata
                                            )
                                        }
                                        coroutineScope.launch {
                                            bottomSheetState.hide()
                                        }
                                    },
                                    initialName = viewModel.selectedTicket.name,
                                    initialPrice = viewModel.selectedTicket.price.toString(),
                                    onNameChange = { name ->
                                        viewModel.updateTicketName(name)
                                    },
                                    onPriceChange = { price ->
                                        viewModel.updateTicketPrice(price)
                                    },
                                    title = stringResource(id = R.string.update_ticket)
                                )
                            }
                            coroutineScope.launch {
                                bottomSheetState.show()
                            }
                        },
                        onAddPhoto = {
                            bottomSheetContent = {
                                AddAttractionPhotoBottomSheetContent(onSubmit = { uri ->
                                    coroutineScope.launch { bottomSheetState.hide() }
                                    val file = createFileFromUri(uri, context)
                                    attraction?.let { wisata ->
                                        file?.let { it1 ->
                                            viewModel.addPhoto(
                                                wisata.id,
                                                it1
                                            )
                                        }
                                    }
                                })
                            }
                            coroutineScope.launch {
                                bottomSheetState.show()
                            }
                        },
                        onDeleteTicket = { ticket ->
                            viewModel.updateSelectedTicket(
                                id = ticket.id,
                                name = ticket.name,
                                price = ticket.price.toString()
                            )
                            openDialog = true
                        },
                        onDeletePhoto = { url ->
                            attraction?.id?.let { it1 -> viewModel.deletePhoto(it1, url) }
                        }
                    )
                },
            )
        },
    )
}

@Composable
fun AttractionDetailContent(
    attraction: WisataDomain?,
    viewModel: AttractionDetailViewModel,
    onAddTicket: () -> Unit,
    onUpdateTicket: (String, String, String) -> Unit,
    onAddPhoto: () -> Unit,
    onDeleteTicket: (TicketWisataDomain) -> Unit,
    onDeletePhoto: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val state = viewModel.state
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = attraction?.name ?: "", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            ExpandingText(
                text = attraction?.description ?: ""
            )
            Spacer(modifier = Modifier.height(16.dp))
            HeadingWithAction(
                title = "Ticket",
                buttonIcon = Icons.Default.Add,
                onButtonClicked = {
                    onAddTicket()
                })
            Spacer(modifier = Modifier.height(16.dp))
            if (state.isTicketLoading) {
                LazyColumn(
                    modifier = Modifier
                        .height(150.dp)
                        .shimmer(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(5) {
                        item {
                            AttractionTicketShimmer()
                        }
                    }
                }
            } else {
                LazyColumn(modifier = Modifier.height(150.dp)) {
                    items(state.tickets, key = { it.id }) { ticket ->
                        AttractionTicketItem(
                            ticket = ticket,
                            onDelete = {
                                onDeleteTicket(ticket)
                            },
                            modifier = Modifier.clickable {
                                onUpdateTicket(ticket.id, ticket.name, ticket.price.toString())
                            }
                        )
                        Divider(color = grey200)
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            HeadingWithAction(
                title = "Photos",
                buttonIcon = Icons.Default.Add,
                onButtonClicked = { onAddPhoto() })
            Spacer(modifier = Modifier.height(16.dp))
            if (state.isPhotoLoading) {
                LazyRow(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    repeat(5) {
                        item {
                            PhotoShimmer()
                        }
                    }
                }
            } else {
                LazyRow(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(state.photos) {
                        PhotoItem(url = it, onDeletePhoto = onDeletePhoto)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttractionDetailScreenPreview() {
    TamansariTheme {
        AttractionDetailScreen(
            attraction = WisataDomain(
                id = "",
                name = "Sendang Seruni",
                photos = arrayListOf(),
                rating = 0f,
                voteCount = 0,
                latitude = 0.0,
                longitude = 0.0,
                description = "Segar dan jernih itulah dua kesan pertama saat melihat panorama pemandian Sendang Seruni, menurut nenek moyang setempat Sendang Seruni dahulunya adalah sumber mata air yang disebut sumber Seruni karena dikelilingi oleh hutan dan tanaman bunga seruni, di area tersebut terdapat  tujuh sumber mata air jernih menyatu menjadi satu, sumber mata air ini  mengalir dari salah satu pegunungan dan membentuk danau kecil yang digunakan mandi oleh masyarakat sekitar dan menurut cerita dahulu. Pernah dibuat mandi para bidadari, sehingga masyarakat Osing setempat menyebutnya dengan nama “Sendang” disamping itu disekitar sumber mata air terdapat banyak tanaman bunga, maka masyarakat Osing setempat menyebutnya tanaman bunga seruni, kemudian masyarakat Osing  setempat memberi nama “Sendang Seruni” untuk  ikon objek wisata di Dusun Sumberwatu, Desa Tamansari, Kecamatan Licin. Masyarakat Osing setempat  meyakini air Sendang Seruni bisa membuat awet muda dan mampu mengurangi penyakit dalam dan rasa capek pada tubuh. Setiap satu tahun di malam satu suro juru kunci Sendang Seruni, Pak Karsono dan masyarakat Osing setempat mengadakan ritual rutin untuk menghormati leluhur yang terdahulu, agar tujuh sumber mata air di Sendang Seruni tetap terjaga kelestariannya juga pengunjung terjaga keselamatannya, khusus kalangan wisatawan perempuan yang sedang berhalangan tidak diperbolehkan melewati tujuh sumber mata air tanpa seijin dari juru kunci karena diyakini sakral oleh masyarakat Osing setempat.\n" +
                        " \n" +
                        "\n" +
                        "  \n" +
                        "Secara umum, kawasan wisata Sendang Seruni mempunyai pendopo Seruni, Pemandian Kolam Dewasa, Pemandian Kolam Anak-   Anak,Gazebo Jejer Sendang Seruni, Gazebo Aren Seruni,\n" +
                        "Gazebo Tangga Seruni, Gazebo Pokmas Seruni , Gazebo Taman Seruni, Gazebo Asri Seruni, Gazebo Pojok Andul Seruni, Gazebo Pojok Bambu, Amfiteater Seruni, UMKM Wisata Kuliner Seruni dan Taman Seruni., Amfiteater Seruni, UMKM Wisata Kuliner Seruni dan Taman Seruni.\n" +
                        "\n" +
                        "Jenis tumbuhan  dan benda alam di wisata Sendang Seruni : Jenis tumbuhan dan benda alam di wisata Sendang Seruni : bunga seruni, bamboo apus, bamboo surat, pohon andul, pohon gula aren, pohon pinang, pohon durian, pohon pakis mas, kopi, jengger ayam, anggur panah, tanaman puring, paku sarang burung, tanaman andong merah, tanaman andong hijau, tanaman trimezia, philodendron, pakis sarang burung, melampodium\n" +
                        "divaricatum, ganyong, nangka, tumbuhan sri rejeki, daun tradescantia, durian, tanaman miana, pisang kalatea atau pisang calathea, nilam, pucuk merah, boroco, batu slendang pertapan dan juga dilengkapi dengan kemudahan akses disabilitas musholla dan toilet.  Dalam pengelolahannya wisata Sendang Seruni dikelola oleh kelompok masyarakat  ( Pokmaswas ) sebagai salah satu unit usaha BUMDesa Ijen Lestari, Desa Wisata Tamansari ( Dewitari ).\n",
                tickets = arrayListOf(
                    TicketWisataDomain(id = "1", name = "Ticket Domestik", price = 5000),
                    TicketWisataDomain(id = "2", name = "Ticket Manca", price = 15000)
                )
            ), navController = rememberNavController()
        )
    }
}

private fun createFileFromUri(uri: Uri, context: Context): File? {
    return try {
        val stream = context.contentResolver.openInputStream(uri)
        val file =
            File.createTempFile(
                "${System.currentTimeMillis()}",
                ".jpg",
                context.cacheDir
            )
        FileUtils.copyInputStreamToFile(
            stream,
            file
        )  // Use this one import org.apache.commons.io.FileUtils
        file
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}