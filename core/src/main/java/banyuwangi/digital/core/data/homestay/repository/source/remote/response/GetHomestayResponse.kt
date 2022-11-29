package banyuwangi.digital.core.data.homestay.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetHomestayResponse(
    val success: Boolean,
    val message: String,
    val data: List<HomestayItem>
)

data class HomestayItem(
    val id: String? = null,
    val name: String? = null,
    val rating: Float? = 0f,
    @field:SerializedName("vote_count") val voteCount: Int? = 0,
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0,
    val description: String? = null,
    val address: String? = null,
    val photos: List<String>? = arrayListOf(),
    @field:SerializedName("check_in") val checkIn: String? = null,
    @field:SerializedName("check_out") val checkOut: String? = null,
    val rooms: List<RoomItem>? = arrayListOf(),
    val facilities: List<FacilityItem>? = arrayListOf()
)