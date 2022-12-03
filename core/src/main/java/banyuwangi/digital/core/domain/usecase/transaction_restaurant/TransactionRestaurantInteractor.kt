package banyuwangi.digital.core.domain.usecase.transaction_restaurant

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionRestaurantDomain
import banyuwangi.digital.core.domain.repository.TransactionRestaurantRepository
import kotlinx.coroutines.flow.Flow

class TransactionRestaurantInteractor(private val repository: TransactionRestaurantRepository) :
    TransactionRestaurantUseCase {
    override fun insertTransaction(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRestaurant: String,
        carts: List<CartRestaurantDomain>,
        ongkir: Int
    ): Flow<Resource<TransactionDomain>> = repository.insertTransaction(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idHomestay,
        idRestaurant,
        carts,
        ongkir
    )

    override fun getTransactionRestaurant(id: String): Flow<Resource<TransactionRestaurantDomain>> {
        return repository.getTransactionRestaurant(id)
    }
}