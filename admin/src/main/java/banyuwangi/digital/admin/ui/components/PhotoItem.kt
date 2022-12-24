package banyuwangi.digital.admin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import banyuwangi.digital.admin.R
import banyuwangi.digital.admin.ui.theme.TamansariTheme
import banyuwangi.digital.admin.ui.theme.grey200
import coil.compose.AsyncImage

@Composable
fun PhotoItem(url: String, onDeletePhoto: (String) -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(150.dp)) {
        AsyncImage(
            model = url,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            modifier = modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(12.dp)
                )
        )
        IconButton(onClick = { onDeletePhoto(url) }, modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color.White)
        }
    }
}

@Composable
fun PhotoShimmer(modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(150.dp)) {
        Spacer(modifier = modifier
            .fillMaxSize()
            .background(grey200))
    }
}


@Preview(showBackground = true)
@Composable
fun PhotoItemPreview() {
    TamansariTheme {
        PhotoItem(url = "", onDeletePhoto = {})
    }
}