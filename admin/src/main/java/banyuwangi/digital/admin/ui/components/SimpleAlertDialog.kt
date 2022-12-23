package banyuwangi.digital.admin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import banyuwangi.digital.admin.ui.theme.TamansariTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SimpleAlertDialog(
    itemId: String,
    item: String,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = { onConfirm(itemId) })
            { Text(text = "OK") }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() })
            { Text(text = "Cancel") }
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        title = { Text(text = "Peringatan") },
        text = {
            Text(
                text = "Apakah anda yakin ingin menghapus $item?",
                modifier = Modifier.fillMaxWidth()
            )
        },
        modifier = Modifier.width(300.dp)
    )
}

@Preview
@Composable
fun SimpleAlertDialogPreview() {
    TamansariTheme {
        SimpleAlertDialog(item = "Tiket Domestik", onDismiss = {}, onConfirm = {}, itemId = "1")
    }
}