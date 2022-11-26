package banyuwangi.digital.core.data.transactions.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transactions.mapper.TransactionsMapper
import banyuwangi.digital.core.data.transactions.repository.source.remote.TransactionsRemoteDataSource
import banyuwangi.digital.core.data.transactions.repository.source.remote.response.GetTransactionsResponse
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.repository.TransactionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TransactionsRepositoryImpl(private val remoteDataSource: TransactionsRemoteDataSource) :
    TransactionsRepository {
    override fun getTransactions(email: String): Flow<Resource<List<TransactionDomain>>> {
        return object : NetworkOnlyResource<List<TransactionDomain>, GetTransactionsResponse>() {
            override fun loadFromNetwork(data: GetTransactionsResponse): Flow<List<TransactionDomain>> {
                val transactions = TransactionsMapper.mapTransactionsItemToDomain(data.data)
                return flowOf(transactions)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetTransactionsResponse>> =
                remoteDataSource.getTransactions(email)

        }.asFlow()
    }

}