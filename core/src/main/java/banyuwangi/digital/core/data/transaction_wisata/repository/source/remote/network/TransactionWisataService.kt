package banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.network

import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.GetTransactionWisataResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.utils.Constant
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface TransactionWisataService {

    @Multipart
    @POST(Constant.API_INSERT_TRANSACTION_WISATA)
    suspend fun insertTransactionWisata(
        @Part("customer_name") customerName: RequestBody,
        @Part("customer_email") customerEmail: RequestBody,
        @Part("customer_phone_number") customerPhoneNumber: RequestBody,
        @Part("fee") fee: RequestBody,
        @Part("convenience_fee") convenienceFee: RequestBody,
        @Part("total_fee") totalFee: RequestBody,
        @Part("id_wisata") idWisata: RequestBody,
        @PartMap chart: HashMap<String, RequestBody>,
    ): InsertTransactionWisataResponse

    @FormUrlEncoded
    @POST(Constant.API_GET_TRANSACTION_WISATA)
    suspend fun getTransactionWisata(@Field("id") id: String): GetTransactionWisataResponse

}