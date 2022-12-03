package banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.network

import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.response.GetTransactionRestaurantResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.utils.Constant
import okhttp3.RequestBody
import retrofit2.http.*

interface TransactionRestaurantService {

    @Multipart
    @POST(Constant.API_INSERT_TRANSACTION_RESTAURANT)
    suspend fun insertTransaction(
        @Part("customer_name") customerName: RequestBody,
        @Part("customer_email") customerEmail: RequestBody,
        @Part("customer_phone_number") customerPhoneNumber: RequestBody,
        @Part("fee") fee: RequestBody,
        @Part("convenience_fee") convenienceFee: RequestBody,
        @Part("total_fee") totalFee: RequestBody,
        @Part("id_homestay") idHomestay: RequestBody,
        @Part("id_restaurant") idRestaurant: RequestBody,
        @PartMap cart: HashMap<String, RequestBody>,
        @Part("ongkir") ongkir: RequestBody
    ): InsertTransactionWisataResponse

    @FormUrlEncoded
    @POST(Constant.API_GET_TRANSACTION_RESTAURANT)
    suspend fun getTransactionRestaurant(@Field("id") id: String): GetTransactionRestaurantResponse
}