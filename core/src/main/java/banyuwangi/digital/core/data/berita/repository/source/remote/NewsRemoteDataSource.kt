package banyuwangi.digital.core.data.berita.repository.source.remote

import banyuwangi.digital.core.data.berita.repository.source.remote.nework.NewsService
import banyuwangi.digital.core.data.berita.repository.source.remote.response.GetNewsResponse
import banyuwangi.digital.core.data.network.ApiResponseOnly
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRemoteDataSource(private val service: NewsService) {

    suspend fun getNews(): Flow<ApiResponseOnly<GetNewsResponse>> {
        return flow {
            try {
                val response = service.getNews()
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