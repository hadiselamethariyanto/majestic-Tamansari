package banyuwangi.digital.core.domain.usecase.transaction_restaurant

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import kotlinx.coroutines.flow.Flow

interface TransactionRestaurantUseCase {

    fun insertTransaction(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRestaurant: String,
        carts: List<CartRestaurantDomain>,
        ongkir:Int
    ): Flow<Resource<TransactionDomain>>
}