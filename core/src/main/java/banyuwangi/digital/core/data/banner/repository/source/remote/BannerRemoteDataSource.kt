package banyuwangi.digital.core.data.banner.repository.source.remote

import banyuwangi.digital.core.data.banner.repository.source.remote.network.BannerService
import banyuwangi.digital.core.data.banner.repository.source.remote.response.GetBannerResponse
import banyuwangi.digital.core.data.network.ApiResponseOnly
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class BannerRemoteDataSource(private val service: BannerService) {

    suspend fun getBanner(): Flow<ApiResponseOnly<GetBannerResponse>> {
        return flow {
            try {
                val response = service.getBanner()
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