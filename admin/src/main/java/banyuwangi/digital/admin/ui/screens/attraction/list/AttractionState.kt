package banyuwangi.digital.admin.ui.screens.attraction.list

import banyuwangi.digital.core.domain.model.WisataDomain

data class AttractionState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<WisataDomain> = emptyList()
)