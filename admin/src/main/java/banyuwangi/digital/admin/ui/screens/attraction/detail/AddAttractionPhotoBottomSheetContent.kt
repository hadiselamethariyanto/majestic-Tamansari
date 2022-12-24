package banyuwangi.digital.admin.ui.screens.attraction.detail

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import banyuwangi.digital.admin.ui.theme.Purple700
import  banyuwangi.digital.admin.R
import banyuwangi.digital.admin.ui.theme.TamansariTheme
import coil.compose.AsyncImage

@Composable
fun AddAttractionPhotoBottomSheetContent(onSubmit: (Uri) -> Unit, modifier: Modifier = Modifier) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri }
    )
    Column(
        Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val stroke = Stroke(
            width = 2f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f), 0f)
        )
        Text(
            text = "Upload Photo",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(36.dp))
        if (selectedImageUri == null) {
            Box(modifier = modifier.size(220.dp)) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawRoundRect(
                        color = Purple700,
                        style = stroke,
                        cornerRadius = CornerRadius(8.dp.toPx())
                    )
                }
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_upload),
                        contentDescription = null,
                        tint = Purple700,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = modifier.height(16.dp))
                    Button(onClick = {
                        singlePhotoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }, shape = RoundedCornerShape(24.dp)) {
                        Text(text = "Browse")
                    }
                    Spacer(modifier = modifier.height(8.dp))
                    Text(
                        text = "Supported files: .jpg, .png, .jpeg",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        } else {
            Box(modifier = Modifier.size(220.dp)) {
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = { selectedImageUri = null },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(36.dp))
        Button(
            onClick = { selectedImageUri?.let { onSubmit(it) } },
            modifier = Modifier.width(220.dp),
            enabled = selectedImageUri != null,
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Upload")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddAttractionPhotoBottomSheetContentPreview() {
    TamansariTheme {
        AddAttractionPhotoBottomSheetContent(onSubmit = {})
    }
}