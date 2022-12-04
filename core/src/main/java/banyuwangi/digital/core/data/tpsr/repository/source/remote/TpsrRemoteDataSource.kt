package banyuwangi.digital.core.data.tpsr.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.tpsr.repository.source.remote.network.TpsrApiService
import banyuwangi.digital.core.data.tpsr.repository.source.remote.response.GetTpsrBalanceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TpsrRemoteDataSource(private val service: TpsrApiService) {

    suspend fun getTpsrBalance(email: String): Flow<ApiResponseOnly<GetTpsrBalanceResponse>> {
        return flow {
            try {
                val response = service.getSaldoTpsr(email)
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