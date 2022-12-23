package banyuwangi.digital.admin.ui.screens.attraction.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import banyuwangi.digital.admin.ui.theme.TamansariTheme

@Composable
fun AddAttractionTicketBottomSheetContent(
    initialName: String,
    initialPrice: String,
    onNameChange: (String) -> Unit,
    onPriceChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Tambah Tiket",
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(16.dp))
            OutlinedTextField(
                value = initialName,
                label = { Text(text = "Nama Tiket") },
                onValueChange = { onNameChange(it) },
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier.height(16.dp))
            OutlinedTextField(
                value = initialPrice,
                label = { Text(text = "Harga Tiket") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { onPriceChange(it) },
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier.height(24.dp))
            Button(
                enabled = initialName.isNotEmpty() && initialPrice.isNotEmpty(),
                onClick = { onSubmit() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddAttractionTicketBottomSheetContentPrev() {
    TamansariTheme {
        AddAttractionTicketBottomSheetContent(
            onSubmit = { },
            initialName = "Tiket domestik",
            initialPrice = "1000",
            onNameChange = { },
            onPriceChange = {}
        )
    }
}