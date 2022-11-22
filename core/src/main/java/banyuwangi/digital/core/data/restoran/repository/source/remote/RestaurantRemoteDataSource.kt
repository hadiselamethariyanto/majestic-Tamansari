package banyuwangi.digital.core.data.restoran.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.restoran.repository.source.remote.network.RestaurantService
import banyuwangi.digital.core.data.restoran.repository.source.remote.response.GetRestaurantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RestaurantRemoteDataSource(private val service: RestaurantService) {

    suspend fun getRestaurant(): Flow<ApiResponseOnly<GetRestaurantResponse>> {
        return flow {
            try {
                val response = service.getRestaurant()
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