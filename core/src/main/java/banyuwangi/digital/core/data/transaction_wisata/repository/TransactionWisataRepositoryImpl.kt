package banyuwangi.digital.core.data.transaction_wisata.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_wisata.mapper.TransactionWisataMapper
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.TransactionWisataRemoteDataSource
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.GetTransactionWisataResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.data.transactions.mapper.TransactionsMapper
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionWisataDomain
import banyuwangi.digital.core.domain.repository.TransactionWisataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TransactionWisataRepositoryImpl(private val remoteDataSource: TransactionWisataRemoteDataSource) :
    TransactionWisataRepository {
    override fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String,
        charts: List<ChartDomain>
    ): Flow<Resource<TransactionDomain>> {
        return object : NetworkOnlyResource<TransactionDomain, InsertTransactionWisataResponse>() {
            override fun loadFromNetwork(data: InsertTransactionWisataResponse): Flow<TransactionDomain> {
                val transaction = TransactionsMapper.mapTransactionItemToDomain(data.data)
                return flowOf(transaction)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> =
                remoteDataSource.insertTransactionWisata(
                    customerName,
                    customerEmail,
                    customerPhoneNumber,
                    fee,
                    convenienceFee,
                    totalFee,
                    idWisata,
                    charts
                )

        }.asFlow()
    }

    override fun getTransactionWisata(id: String): Flow<Resource<TransactionWisataDomain>> {
        return object :
            NetworkOnlyResource<TransactionWisataDomain, GetTransactionWisataResponse>() {
            override fun loadFromNetwork(data: GetTransactionWisataResponse): Flow<TransactionWisataDomain> {
                val response =
                    TransactionWisataMapper.mapTransactionWisataResponseToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetTransactionWisataResponse>> =
                remoteDataSource.getTransactionWisata(id)

        }.asFlow()
    }
}