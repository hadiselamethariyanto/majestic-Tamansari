package banyuwangi.digital.core.data.transaction_homestay.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.network.TransactionHomestayService
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TransactionHomestayRemoteDataSource(private val service: TransactionHomestayService) {

    suspend fun insertTransactionHomestay(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRoom: String,
        checkIn: String,
        checkOut: String,
        totalPerson: Int
    ): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> {
        return flow {
            try {
                val response = service.insertTransactionHomestay(
                    customerName,
                    customerEmail,
                    customerPhoneNumber,
                    fee,
                    convenienceFee,
                    totalFee,
                    idHomestay,
                    idRoom,
                    checkIn,
                    checkOut,
                    totalPerson
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