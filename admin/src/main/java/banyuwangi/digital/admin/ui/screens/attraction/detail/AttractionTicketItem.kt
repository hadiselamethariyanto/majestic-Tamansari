package banyuwangi.digital.admin.ui.screens.attraction.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import banyuwangi.digital.admin.ui.theme.TamansariTheme
import banyuwangi.digital.admin.ui.theme.grey200
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import com.bwx.tamansari.utils.Utils


@Composable
fun AttractionTicketItem(
    ticket: TicketWisataDomain,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = ticket.name, fontSize = 14.sp, modifier = Modifier.weight(1f))
        Text(text = Utils.thousandSeparator(ticket.price), fontSize = 14.sp)
        IconButton(onClick = { onDelete() }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }
    }
}

@Composable
fun AttractionTicketShimmer(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(grey200)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AttractionTicketItemPreview() {
    TamansariTheme {
        AttractionTicketItem(
            ticket = TicketWisataDomain("1", "Tiket wisata", 5000),
            onDelete = { })
    }
}