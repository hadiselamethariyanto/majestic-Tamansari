package banyuwangi.digital.core.data.transaction_restaurant.mapper

import banyuwangi.digital.core.data.homestay.mapper.HomestayMapper
import banyuwangi.digital.core.data.restoran.mapper.RestaurantMapper
import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.response.DataTransactionRestaurantItem
import banyuwangi.digital.core.domain.model.TransactionRestaurantDomain

object TransactionRestaurantMapper {

    fun mapTransactionRestaurantItemToDomain(data: DataTransactionRestaurantItem): TransactionRestaurantDomain =
        TransactionRestaurantDomain(
            restaurant = RestaurantMapper.mapRestaurantItemToDomain(data.restaurant),
            homestay = HomestayMapper.mapHomestayItemToDomain(data.homestay),
            ongkir = data.ongkir
        )

}