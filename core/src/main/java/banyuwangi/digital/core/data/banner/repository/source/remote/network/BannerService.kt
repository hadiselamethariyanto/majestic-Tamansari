package banyuwangi.digital.core.data.banner.repository.source.remote.network

import banyuwangi.digital.core.data.banner.repository.source.remote.response.GetBannerResponse
import banyuwangi.digital.core.utils.Constant
import retrofit2.http.GET

interface BannerService {

    @GET(Constant.API_GET_BANNER)
    suspend fun getBanner(): GetBannerResponse
}