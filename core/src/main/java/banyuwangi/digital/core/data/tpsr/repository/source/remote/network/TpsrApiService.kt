package banyuwangi.digital.core.data.tpsr.repository.source.remote.network

import banyuwangi.digital.core.data.tpsr.repository.source.remote.response.GetTpsrBalanceResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TpsrApiService {

    @FormUrlEncoded
    @POST(Constant.API_GET_TPSR_BALANCE)
    suspend fun getSaldoTpsr(@Field("email") email: String): GetTpsrBalanceResponse

}