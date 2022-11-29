package banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.network

import banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.response.GetTransactionHomestayResponse
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TransactionHomestayService {

    @FormUrlEncoded
    @POST(Constant.API_INSERT_TRANSACTION_HOMESTAY)
    suspend fun insertTransactionHomestay(
        @Field("customer_name") customerName: String,
        @Field("customer_email") customerEmail: String,
        @Field("customer_phone_number") customerPhoneNumber: String,
        @Field("fee") fee: Int,
        @Field("convenience_fee") convenienceFee: Int,
        @Field("total_fee") totalFee: Int,
        @Field("id_homestay") idHomestay: String,
        @Field("id_room") idRoom: String,
        @Field("check_in") checkIn: String,
        @Field("check_out") checkOut: String,
        @Field("total_person") totalPerson: Int
    ): InsertTransactionWisataResponse

    @FormUrlEncoded
    @POST(Constant.API_GET_TRANSACTION_HOMESTAY)
    suspend fun getTransactionHomestay(@Field("id") id: String): GetTransactionHomestayResponse
}