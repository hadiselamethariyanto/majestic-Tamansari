package banyuwangi.digital.core.data.homestay.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class RoomItem(
    val id: String,
    val name: String,
    val area: Int,
    val capacity: Int,
    @field:SerializedName("bed_type") val bedType: String,
    val breakfast: Int,
    val price: Int
)