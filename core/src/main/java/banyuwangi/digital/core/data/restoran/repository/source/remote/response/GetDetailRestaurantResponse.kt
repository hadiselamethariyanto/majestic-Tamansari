package banyuwangi.digital.core.data.restoran.repository.source.remote.response

data class GetDetailRestaurantResponse(
    val success: Boolean,
    val message: String,
    val data: RestaurantItem
)