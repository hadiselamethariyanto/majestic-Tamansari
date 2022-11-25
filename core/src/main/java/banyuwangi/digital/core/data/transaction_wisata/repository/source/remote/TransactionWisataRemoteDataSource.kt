package banyuwangi.digital.core.data.transaction_wisata.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.network.TransactionWisataService
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class TransactionWisataRemoteDataSource(private val service: TransactionWisataService) {

    suspend fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String
    ): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> {
        return flow {
            try {
                val chartMap: HashMap<String, RequestBody> = HashMap()
//                for ((index, room) in rooms.withIndex()) {
//                    roomsMap["rooms[${index}][id]"] =
//                        room.idRoom.toRequestBody("text/plain".toMediaType())
//                    roomsMap["rooms[${index}][quantity]"] =
//                        room.quantity.toString().toRequestBody("text/plain".toMediaType())
//                    roomsMap["rooms[${index}][price]"] =
//                        room.price.toString().toRequestBody("text/plain".toMediaType())
//                }

                val response =
                    service.insertTransactionWisata(
                        customerName = customerName.toRequestBody("text/plain".toMediaType()),
                        customerEmail = customerEmail.toRequestBody("text/plain".toMediaType()),
                        customerPhoneNumber = customerPhoneNumber.toRequestBody("text/plain".toMediaType()),
                        fee = fee.toString().toRequestBody("text/plain".toMediaType()),
                        convenienceFee = convenienceFee.toString()
                            .toRequestBody("text/plain".toMediaType()),
                        totalFee = totalFee.toString().toRequestBody("text/plain".toMediaType()),
                        idWisata = idWisata.toRequestBody("text/plain".toMediaType()),
                        chart = chartMap
                    )
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