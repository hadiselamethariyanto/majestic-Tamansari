package banyuwangi.digital.core.data.restoran.repository.source.remote.network

import banyuwangi.digital.core.data.restoran.repository.source.remote.response.GetRestaurantResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface RestaurantService {

    @GET(Constant.API_GET_RESTAURANT)
    suspend fun getRestaurant(): GetRestaurantResponse
}