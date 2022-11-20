package banyuwangi.digital.core.data.wisata.repository.source.remote.network

import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataRatingResponse
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WisataService {
    @GET(Constant.API_GET_WISATA)
    suspend fun getWisata(): GetWisataResponse

    @POST(Constant.API_GET_WISATA_RATING)
    @FormUrlEncoded
    suspend fun getWisataRating(@Field("id_wisata") idWisata: String): GetWisataRatingResponse
}