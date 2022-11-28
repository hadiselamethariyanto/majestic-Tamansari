package banyuwangi.digital.core.data.payment.repository.source.remote.network

import banyuwangi.digital.core.data.payment.repository.source.remote.response.ChargeEWalletResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PaymentService {

    @FormUrlEncoded
    @POST(Constant.API_CHARGE_EWALLET)
    suspend fun chargeEWallet(
        @Field("order_id") orderId: String,
        @Field("channel_code") channelCode: String,
        @Field("amount") amount: Int
    ): ChargeEWalletResponse

}