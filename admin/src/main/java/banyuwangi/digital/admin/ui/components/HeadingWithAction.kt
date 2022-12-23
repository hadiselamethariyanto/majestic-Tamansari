package banyuwangi.digital.admin.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import banyuwangi.digital.admin.ui.theme.TamansariTheme

@Composable
fun HeadingWithAction(
    title: String,
    buttonIcon: ImageVector,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onButtonClicked() }) {
            Icon(buttonIcon, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun HeadingWithActionPrev() {
    TamansariTheme {
        HeadingWithAction(
            title = "Photos",
            buttonIcon = Icons.Default.Add,
            onButtonClicked = { /*TODO*/ })
    }
}