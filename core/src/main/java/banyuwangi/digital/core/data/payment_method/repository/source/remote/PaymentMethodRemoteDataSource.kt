package banyuwangi.digital.core.data.payment_method.repository.source.remote

import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.payment_method.repository.source.remote.network.PaymentMethodService
import banyuwangi.digital.core.data.payment_method.repository.source.remote.response.GetPaymentMethodResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PaymentMethodRemoteDataSource(private val service: PaymentMethodService) {

    suspend fun getPaymentMethod(): Flow<ApiResponseOnly<GetPaymentMethodResponse>> {
        return flow {
            try {
                val response = service.getPaymentMethod()
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