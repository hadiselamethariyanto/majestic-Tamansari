package banyuwangi.digital.core.data.search.repository.source.remote.network

import banyuwangi.digital.core.data.peta.repository.source.remote.response.GetMapsOutletResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SearchApiService {

    @FormUrlEncoded
    @POST(Constant.API_SEARCH)
    suspend fun search(@Field("keyword") keyword: String): GetMapsOutletResponse
}