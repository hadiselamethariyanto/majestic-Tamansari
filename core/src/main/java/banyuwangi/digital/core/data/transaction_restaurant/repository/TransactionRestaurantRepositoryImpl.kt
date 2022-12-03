package banyuwangi.digital.core.data.transaction_restaurant.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.TransactionRestaurantRemoteDataSource
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.data.transactions.mapper.TransactionsMapper
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.repository.TransactionRestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TransactionRestaurantRepositoryImpl(private val remoteDataSource: TransactionRestaurantRemoteDataSource) :
    TransactionRestaurantRepository {
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
        ongkir:Int
    ): Flow<Resource<TransactionDomain>> {
        return object : NetworkOnlyResource<TransactionDomain, InsertTransactionWisataResponse>() {
            override fun loadFromNetwork(data: InsertTransactionWisataResponse): Flow<TransactionDomain> {
                val response = TransactionsMapper.mapTransactionItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> =
                remoteDataSource.insertTransactionRestaurant(
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

        }.asFlow()
    }
}