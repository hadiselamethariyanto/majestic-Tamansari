package banyuwangi.digital.core.data.wisata.repository.source.remote.response

data class DeletePhotoWisataResponse(
    val success: Boolean,
    val message: String,
    val data: List<String>
)
