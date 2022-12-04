package banyuwangi.digital.core.data.peta.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.peta.repository.source.remote.network.MapsService
import banyuwangi.digital.core.data.peta.repository.source.remote.response.GetMapsOutletResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MapsRemoteDataSource(private val service: MapsService) {

    suspend fun getMapsOutlet(): Flow<ApiResponseOnly<GetMapsOutletResponse>> {
        return flow {
            try {
                val response = service.getMapsOutlet()
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