package banyuwangi.digital.core.data.payment_method.repository.source.remote.network

import banyuwangi.digital.core.data.payment_method.repository.source.remote.response.GetPaymentMethodResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface PaymentMethodService {

    @GET(Constant.API_GET_PAYMENT_METHOD)
    suspend fun getPaymentMethod(): GetPaymentMethodResponse
}