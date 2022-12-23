package banyuwangi.digital.admin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultModalBottomSheetDialog(
    bottomSheetState: ModalBottomSheetState,
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            sheetContent()
        },
        sheetShape = RoundedCornerShape(32.dp, 32.dp),
        sheetElevation = 8.dp,
    ) {
        content()
    }
}