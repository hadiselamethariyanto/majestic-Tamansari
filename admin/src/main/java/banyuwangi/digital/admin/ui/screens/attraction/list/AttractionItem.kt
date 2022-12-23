package banyuwangi.digital.admin.ui.screens.attraction.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import banyuwangi.digital.admin.ui.theme.TamansariTheme
import banyuwangi.digital.core.domain.model.WisataDomain

@Composable
fun AttractionItem(attraction: WisataDomain, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(16.dp).fillMaxWidth()) {
        Text(text = attraction.name)
    }
}

@Preview(showBackground = true)
@Composable
fun AttractionItemPreview() {
    TamansariTheme {
        AttractionItem(
            attraction = WisataDomain(
                id = "1",
                name = "Sendang Seruni",
                photos = arrayListOf(),
                description = "",
                latitude = 0.0,
                longitude = 0.0,
                rating = 5f,
                voteCount = 132
            )
        )
    }
}