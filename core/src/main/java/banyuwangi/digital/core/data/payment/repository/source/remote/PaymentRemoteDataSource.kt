package banyuwangi.digital.core.data.payment.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.payment.repository.source.remote.network.PaymentService
import banyuwangi.digital.core.data.payment.repository.source.remote.response.ChargeEWalletResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PaymentRemoteDataSource(private val service: PaymentService) {

    suspend fun chargeEWallet(
        orderId: String,
        channelCode: String,
        amount: Int
    ): Flow<ApiResponseOnly<ChargeEWalletResponse>> {
        return flow {
            try {
                val response = service.chargeEWallet(orderId, channelCode, amount)
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