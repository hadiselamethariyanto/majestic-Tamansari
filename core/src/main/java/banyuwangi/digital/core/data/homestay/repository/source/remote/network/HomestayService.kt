package banyuwangi.digital.core.data.homestay.repository.source.remote.network

import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetAvailabilityRooms
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetDetailHomestayResponse
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetHomestayResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface HomestayService {

    @GET(Constant.API_GET_HOMESTAY)
    suspend fun getHomestay(): GetHomestayResponse

    @POST(Constant.API_GET_DETAIL_HOMESTAY)
    @FormUrlEncoded
    suspend fun getDetailHomestay(@Field("id_homestay") idHomestay: String): GetDetailHomestayResponse

    @POST(Constant.API_GET_AVAILABILITY_ROOMS)
    @FormUrlEncoded
    suspend fun getAvailabilityRooms(
        @Field("id_homestay") idHomestay: String,
        @Field("checkin") checkin: String,
        @Field("checkout") checkout: String
    ): GetAvailabilityRooms


}