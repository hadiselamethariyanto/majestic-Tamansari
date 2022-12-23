package banyuwangi.digital.admin.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import banyuwangi.digital.admin.ui.theme.TamansariTheme

private val screens = listOf(
    Screen.Home,
    Screen.Attraction,
    Screen.Homestay
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    TamansariTheme {
        Drawer{}
    }
}