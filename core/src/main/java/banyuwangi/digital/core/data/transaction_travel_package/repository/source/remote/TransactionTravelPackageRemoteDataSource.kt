package banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.network.TransactionTravelPackageService
import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.response.GetTransactionTravelPackageResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TransactionTravelPackageRemoteDataSource(private val service: TransactionTravelPackageService) {
    suspend fun insertTransactionTravelPackage(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idTravelPackage: String,
        idTravelPackageType: String,
        selectedDate: String
    ): Flow<ApiResponseOnly<InsertTransactionWisataResponse>> {
        return flow {
            try {
                val response = service.insertTransaction(
                    customerName,
                    customerEmail,
                    customerPhoneNumber,
                    fee,
                    convenienceFee,
                    totalFee,
                    idTravelPackage,
                    idTravelPackageType,
                    selectedDate
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

    suspend fun getTransactionTravelPackage(id: String): Flow<ApiResponseOnly<GetTransactionTravelPackageResponse>> {
        return flow {
            try {
                val response = service.getTransactionTravelPackage(id)
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