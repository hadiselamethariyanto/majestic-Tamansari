package banyuwangi.digital.core.data.search.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.peta.repository.source.remote.response.GetMapsOutletResponse
import banyuwangi.digital.core.data.search.repository.source.remote.network.SearchApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SearchRemoteDataSource(private val service: SearchApiService) {

    suspend fun search(keyword: String): Flow<ApiResponseOnly<GetMapsOutletResponse>> {
        return flow {
            try {
                val response = service.search(keyword)
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