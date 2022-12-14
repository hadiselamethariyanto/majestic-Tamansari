package banyuwangi.digital.core.data.homestay.repository.source.remote

import banyuwangi.digital.core.data.homestay.repository.source.remote.network.HomestayService
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetAvailabilityRooms
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetDetailHomestayResponse
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetHomestayResponse
import banyuwangi.digital.core.data.network.ApiResponseOnly
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomestayRemoteDataSource(private val service: HomestayService) {

    suspend fun getHomestay(): Flow<ApiResponseOnly<GetHomestayResponse>> {
        return flow {
            try {
                val response = service.getHomestay()
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

    suspend fun getDetailHomestay(idHomestay: String): Flow<ApiResponseOnly<GetDetailHomestayResponse>> {
        return flow {
            try {
                val response = service.getDetailHomestay(idHomestay)
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

    suspend fun getAvailabilityRooms(
        idHomestay: String,
        checkin: String,
        checkout: String
    ): Flow<ApiResponseOnly<GetAvailabilityRooms>> {
        return flow {
            try {
                val response = service.getAvailabilityRooms(idHomestay, checkin, checkout)
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