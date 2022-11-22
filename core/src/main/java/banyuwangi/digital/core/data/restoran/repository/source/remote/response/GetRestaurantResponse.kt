package banyuwangi.digital.core.data.restoran.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetRestaurantResponse(
    val success: Boolean,
    val message: String,
    val data: List<RestaurantItem>
)

data class RestaurantItem(
    val id: String,
    val name: String,
    val rating: Float,
    val category:String,
    @field:SerializedName("vote_count") val voteCount: Int,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    @field:SerializedName("photo_url") val photoUrl: String,
    val menus: List<RestaurantMenuItem>
)