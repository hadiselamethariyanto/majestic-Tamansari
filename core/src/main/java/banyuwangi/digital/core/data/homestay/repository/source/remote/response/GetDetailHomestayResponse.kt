package banyuwangi.digital.core.data.homestay.repository.source.remote.response

data class GetDetailHomestayResponse(
    val success: Boolean,
    val message: String,
    val data: HomestayItem
)