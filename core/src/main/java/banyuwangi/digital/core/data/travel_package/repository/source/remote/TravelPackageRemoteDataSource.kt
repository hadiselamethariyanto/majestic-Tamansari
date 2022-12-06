package banyuwangi.digital.core.data.travel_package.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.travel_package.repository.source.remote.network.TravelPackageService
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.GetDetailTravelPackageResponse
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.GetTravelPackageResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TravelPackageRemoteDataSource(private val service: TravelPackageService) {

    suspend fun getTravelPackage(): Flow<ApiResponseOnly<GetTravelPackageResponse>> {
        return flow {
            try {
                val response = service.getTravelPackage()
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

    suspend fun getDetailTravelPackage(id: String): Flow<ApiResponseOnly<GetDetailTravelPackageResponse>> {
        return flow {
            try {
                val response = service.getDetailTravelPackage(id)
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