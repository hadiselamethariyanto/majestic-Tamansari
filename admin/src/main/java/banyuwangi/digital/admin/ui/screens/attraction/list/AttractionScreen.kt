package banyuwangi.digital.admin.ui.screens.attraction.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import banyuwangi.digital.admin.ui.components.TopBar
import banyuwangi.digital.admin.ui.navigation.Screen
import banyuwangi.digital.admin.ui.theme.grey200
import banyuwangi.digital.admin.utils.Utils.toJson
import banyuwangi.digital.core.domain.model.WisataDomain
import org.koin.androidx.compose.koinViewModel

@Composable
fun AttractionScreen(
    openDrawer: () -> Unit,
    navController: NavController,
    attractionViewModel: AttractionViewModel = koinViewModel()
) {
    val state = attractionViewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Attraction",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (state.error != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error
                )
            }
        } else {
            AttractionContent(state.data, navController = navController)
        }
    }
}

@Composable
fun AttractionContent(
    data: List<WisataDomain>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn {
            items(data, key = { it.id }) { attraction ->
                AttractionItem(attraction = attraction, modifier = Modifier.clickable {
                    navController.navigate(Screen.AttractionDetail.createRoute(attraction.id, attraction.toJson()))
                })
                Divider(color = grey200)
            }
        }
    }
}