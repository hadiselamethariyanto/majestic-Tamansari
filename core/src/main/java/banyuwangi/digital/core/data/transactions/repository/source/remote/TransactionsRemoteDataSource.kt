package banyuwangi.digital.core.data.transactions.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transactions.repository.source.remote.network.TransactionsService
import banyuwangi.digital.core.data.transactions.repository.source.remote.response.GetTransactionsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TransactionsRemoteDataSource(private val service: TransactionsService) {

    fun getTransactions(email: String): Flow<ApiResponseOnly<GetTransactionsResponse>> {
        return flow {
            try {
                val response = service.getTransactions(email)
                if (response.success) {
                    emit(ApiResponseOnly.Success(response))
                } else {
                    emit(ApiResponseOnly.Error(response.message))
                }
            } catch (e: Exception) {
                emit(ApiResponseOnly.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}