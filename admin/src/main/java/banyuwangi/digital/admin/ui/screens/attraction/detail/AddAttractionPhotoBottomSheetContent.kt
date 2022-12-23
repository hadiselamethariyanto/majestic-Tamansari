package banyuwangi.digital.admin.ui.screens.attraction.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import banyuwangi.digital.admin.ui.theme.Purple700

@Composable
fun AddAttractionPhotoBottomSheetContent() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Purple700)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello Geek!", fontSize = 20.sp, color = Color.White)
        }
    }
}