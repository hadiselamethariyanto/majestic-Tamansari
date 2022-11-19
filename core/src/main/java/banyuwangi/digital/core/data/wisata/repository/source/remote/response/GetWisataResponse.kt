package banyuwangi.digital.core.data.wisata.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetWisataResponse(val success: Boolean, val message: String, val data: List<WisataItem>)

data class WisataItem(
    val id: String,
    val name: String,
    val rating: Float,
    @field:SerializedName("vote_count") val voteCount: Int,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val address: String,
    val photos: List<String>,
    val tickets: List<TicketWisataItem>
)
