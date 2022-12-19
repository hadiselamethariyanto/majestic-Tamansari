package banyuwangi.digital.core.data.banner.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetBannerResponse(
    val success: Boolean,
    val message: String,
    val data: List<BannerItem>
)

data class BannerItem(
    val id: Int,
    @field:SerializedName("backdrop_url") val backdropUrl: String,
    @field:SerializedName("redirect_url") val redirectUrl: String
)
