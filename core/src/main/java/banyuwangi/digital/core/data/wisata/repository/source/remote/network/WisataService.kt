package banyuwangi.digital.core.data.wisata.repository.source.remote.network

import banyuwangi.digital.core.data.wisata.repository.source.remote.response.DeleteTicketWisataResponse
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetDetailWisataResponse
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

    @POST(Constant.API_GET_DETAIL_WISATA)
    @FormUrlEncoded
    suspend fun getDetailWisata(@Field("id_wisata") idWisata: String): GetDetailWisataResponse

    @POST(Constant.API_DELETE_TICKET)
    @FormUrlEncoded
    suspend fun deleteTicket(
        @Field("id_wisata") idWisata: String,
        @Field("id") id: String
    ): DeleteTicketWisataResponse

    @POST(Constant.API_ADD_TICKET)
    @FormUrlEncoded
    suspend fun addTicket(
        @Field("id_wisata") idWisata: String,
        @Field("name") name: String,
        @Field("price") price: String
    ): DeleteTicketWisataResponse
}