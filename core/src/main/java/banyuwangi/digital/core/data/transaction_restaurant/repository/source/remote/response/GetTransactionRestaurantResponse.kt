package banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.response

import banyuwangi.digital.core.data.homestay.repository.source.remote.response.HomestayItem
import banyuwangi.digital.core.data.restoran.repository.source.remote.response.RestaurantItem

data class GetTransactionRestaurantResponse(
    val success: Boolean,
    val message: String,
    val data: DataTransactionRestaurantItem
)

data class DataTransactionRestaurantItem(
    val restaurant: RestaurantItem,
    val homestay: HomestayItem,
    val ongkir: Int
)