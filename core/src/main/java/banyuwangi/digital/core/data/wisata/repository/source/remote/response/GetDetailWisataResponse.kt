package banyuwangi.digital.core.data.wisata.repository.source.remote.response

data class GetDetailWisataResponse(
    val success: Boolean,
    val message: String,
    val data: WisataItem
)