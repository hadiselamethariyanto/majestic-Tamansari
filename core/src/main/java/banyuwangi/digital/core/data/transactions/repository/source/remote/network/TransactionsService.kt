package banyuwangi.digital.core.data.transactions.repository.source.remote.network

import banyuwangi.digital.core.data.transactions.repository.source.remote.response.GetTransactionsResponse
import banyuwangi.digital.core.data.transactions.repository.source.remote.response.UpdateExpiredTransactionResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TransactionsService {

    @FormUrlEncoded
    @POST(Constant.API_GET_TRANSACTIONS)
    suspend fun getTransactions(@Field("email") email: String): GetTransactionsResponse

    @FormUrlEncoded
    @POST(Constant.API_UPDATE_EXPIRED_TRANSACTION)
    suspend fun updateExpiredTransaction(@Field("id") id: String): UpdateExpiredTransactionResponse

}