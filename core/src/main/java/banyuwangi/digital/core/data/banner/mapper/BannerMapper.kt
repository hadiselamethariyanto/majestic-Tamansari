package banyuwangi.digital.core.data.banner.mapper

import banyuwangi.digital.core.data.banner.repository.source.remote.response.BannerItem
import banyuwangi.digital.core.domain.model.BannerDomain

object BannerMapper {

    fun mapBannerItemToDomain(banner: List<BannerItem>): List<BannerDomain> = banner.map {
        BannerDomain(
            id = it.id,
            backdropUrl = it.backdropUrl,
            redirectUrl = it.redirectUrl
        )
    }
}