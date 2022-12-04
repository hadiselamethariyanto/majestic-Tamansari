package banyuwangi.digital.core.data.restoran.repository.source.remote.network

import banyuwangi.digital.core.data.restoran.repository.source.remote.response.GetDetailRestaurantResponse
import banyuwangi.digital.core.data.restoran.repository.source.remote.response.GetRestaurantResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RestaurantService {

    @GET(Constant.API_GET_RESTAURANT)
    suspend fun getRestaurant(): GetRestaurantResponse

    @FormUrlEncoded
    @POST(Constant.API_GET_DETAIL_RESTAURANT)
    suspend fun getDetailRestaurant(@Field("id_restaurant") id: String): GetDetailRestaurantResponse


}