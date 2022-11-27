package banyuwangi.digital.core.data.wisata.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetWisataResponse(val success: Boolean, val message: String, val data: List<WisataItem>)

data class WisataItem(
    val id: String? = null,
    val name: String? = null,
    val rating: Float? = null,
    @field:SerializedName("vote_count") val voteCount: Int? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val description: String? = null,
    val address: String? = null,
    val photos: List<String>? = arrayListOf(),
    val tickets: List<TicketWisataItem>? = arrayListOf()
)
