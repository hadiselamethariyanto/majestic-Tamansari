package banyuwangi.digital.core.data.wisata.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.wisata.repository.source.remote.network.WisataService
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.DeleteTicketWisataResponse
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetDetailWisataResponse
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataRatingResponse
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WisataRemoteDataSource(private val service: WisataService) {

    suspend fun getWisata(): Flow<ApiResponseOnly<GetWisataResponse>> {
        return flow {
            try {
                val response = service.getWisata()
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

    suspend fun getDetailWisata(idWisata: String): Flow<ApiResponseOnly<GetDetailWisataResponse>> {
        return flow {
            try {
                val response = service.getDetailWisata(idWisata)
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

    suspend fun getWisataRating(idWisata: String): Flow<ApiResponseOnly<GetWisataRatingResponse>> {
        return flow {
            try {
                val response = service.getWisataRating(idWisata)
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

    suspend fun deleteTicket(
        idWisata: String,
        id: String
    ): Flow<ApiResponseOnly<DeleteTicketWisataResponse>> {
        return flow {
            try {
                val response = service.deleteTicket(idWisata, id)
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

    suspend fun addTicket(
        idWisata: String,
        name: String,
        price: String
    ): Flow<ApiResponseOnly<DeleteTicketWisataResponse>> {
        return flow {
            try {
                val response = service.addTicket(idWisata, name, price)
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