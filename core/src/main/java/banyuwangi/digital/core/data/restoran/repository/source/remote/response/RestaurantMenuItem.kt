package banyuwangi.digital.core.data.restoran.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class RestaurantMenuItem(
    val id: String,
    val name: String,
    val price: Int,
    @field:SerializedName("photo_url") val photoUrl: String
)