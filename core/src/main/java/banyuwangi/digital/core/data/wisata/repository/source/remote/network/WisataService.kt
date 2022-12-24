package banyuwangi.digital.core.data.wisata.repository.source.remote.network

import banyuwangi.digital.core.data.wisata.repository.source.remote.response.*
import banyuwangi.digital.core.utils.Constant
import okhttp3.MultipartBody
import retrofit2.http.*

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

    @POST(Constant.API_EDIT_TICKET)
    @FormUrlEncoded
    suspend fun editTicket(
        @Field("id_wisata") idWisata: String,
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("id") id: String
    ): DeleteTicketWisataResponse

    @POST(Constant.API_DELETE_PHOTO)
    @FormUrlEncoded
    suspend fun deletePhoto(
        @Field("id_wisata") idWisata: String,
        @Field("url") url: String
    ): DeletePhotoWisataResponse

    @POST(Constant.API_ADD_PHOTO)
    suspend fun addPhoto(
        @Header("Content-Type") contentType: String,
        @Body body: MultipartBody
    ): DeletePhotoWisataResponse

}