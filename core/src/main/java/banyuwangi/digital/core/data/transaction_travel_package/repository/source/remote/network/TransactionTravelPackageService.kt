package banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.network

import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.InsertTransactionWisataResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TransactionTravelPackageService {

    @FormUrlEncoded
    @POST(Constant.API_INSERT_TRANSACTION_TRAVEL_PACKAGE)
    suspend fun insertTransaction(
        @Field("customer_name") customerName: String,
        @Field("customer_email") customerEmail: String,
        @Field("customer_phone_number") customerPhoneNumber: String,
        @Field("fee") fee: Int,
        @Field("convenience_fee") convenienceFee: Int,
        @Field("total_fee") totalFee: Int,
        @Field("id_travel_package") idTravelPackage: String,
        @Field("id_travel_package_type") idTravelPackageType: String,
        @Field("selected_date") selectedDate: String
    ): InsertTransactionWisataResponse
}