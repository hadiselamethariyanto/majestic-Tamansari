package banyuwangi.digital.core.data.travel_package.repository.source.remote.network

import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.GetDetailTravelPackageResponse
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.GetTravelPackageResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface TravelPackageService {

    @GET(Constant.API_GET_TRAVEL_PACKAGE)
    suspend fun getTravelPackage(): GetTravelPackageResponse

    @FormUrlEncoded
    @POST(Constant.API_GET_DETAIL_TRAVEL_PACKAGE)
    suspend fun getDetailTravelPackage(@Field("id_travel_package") id: String): GetDetailTravelPackageResponse
}