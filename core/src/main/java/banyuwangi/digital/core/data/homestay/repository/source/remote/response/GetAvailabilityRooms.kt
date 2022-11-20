package banyuwangi.digital.core.data.homestay.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetAvailabilityRooms(
    val success: Boolean,
    val message: String,
    val data: List<AvailableRoomItem>
)

data class AvailableRoomItem(
    val id: String,
    val name: String,
    val price: Int,
    val area: Int,
    val capacity: Int,
    @field:SerializedName("bed_type") val bedType: String,
    val breakfast: Int,
    @field:SerializedName("rooms_available") val roomsAvailable: Int,
    val photos: List<String>
)