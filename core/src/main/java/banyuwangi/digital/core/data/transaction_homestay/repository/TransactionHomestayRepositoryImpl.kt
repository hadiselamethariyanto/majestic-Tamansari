package banyuwangi.digital.core.data.transaction_homestay.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.TransactionHomestayRemoteDataSource
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.data.transactions.mapper.TransactionsMapper
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.repository.TransactionHomestayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TransactionHomestayRepositoryImpl(private val remoteDataSource: TransactionHomestayRemoteDataSource) :
    TransactionHomestayRepository {
    override fun insertTransactionHomestay(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRoom: String,
        checkIn: String,
        checkOut: String,
        totalPerson: Int
    ): Flow<Resource<TransactionDomain>> {
        return object : NetworkOnlyResource<TransactionDomain, InsertTransactionWisataResponse>() {
            override fun loadFromNetwork(data: InsertTransactionWisataResponse): Flow<TransactionDomain> {
                val response = TransactionsMapper.mapTransactionItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> =
                remoteDataSource.insertTransactionHomestay(
                    customerName,
                    customerEmail,
                    customerPhoneNumber,
                    fee,
                    convenienceFee,
                    totalFee,
                    idHomestay,
                    idRoom,
                    checkIn,
                    checkOut,
                    totalPerson
                )
        }.asFlow()
    }
}