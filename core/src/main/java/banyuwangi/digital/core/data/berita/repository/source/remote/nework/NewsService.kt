package banyuwangi.digital.core.data.berita.repository.source.remote.nework

import banyuwangi.digital.core.data.berita.repository.source.remote.response.GetNewsResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface NewsService {

    @GET(Constant.API_GET_NEWS)
    suspend fun getNews(): GetNewsResponse
}