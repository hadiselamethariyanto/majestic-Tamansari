package banyuwangi.digital.admin.ui.screens.attraction.detail

import banyuwangi.digital.core.domain.model.TicketWisataDomain

data class AttractionDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val tickets: List<TicketWisataDomain> = emptyList(),
    val isTicketLoading: Boolean = false
)