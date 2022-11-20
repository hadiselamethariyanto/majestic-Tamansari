package banyuwangi.digital.core.data.homestay.repository.source.remote.network

import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetHomestayResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface HomestayService {

    @GET(Constant.API_GET_HOMESTAY)
    suspend fun getHomestay(): GetHomestayResponse
}