package banyuwangi.digital.core.data.wisata.repository.source.remote.response

data class DeleteTicketWisataResponse(
    val success: Boolean,
    val message: String,
    val data: List<TicketWisataItem>
)