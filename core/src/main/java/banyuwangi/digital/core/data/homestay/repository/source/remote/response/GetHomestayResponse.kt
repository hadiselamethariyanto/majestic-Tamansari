package banyuwangi.digital.core.data.homestay.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetHomestayResponse(
    val success: Boolean,
    val message: String,
    val data: List<HomestayItem>
)

data class HomestayItem(
    val id: String,
    val name: String,
    val rating: Float,
    @field:SerializedName("vote_count") val voteCount: Int,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val address: String,
    val photos: List<String>,
    @field:SerializedName("check_in") val checkIn: String,
    @field:SerializedName("check_out") val checkOut: String
)