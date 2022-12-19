package banyuwangi.digital.core.domain.usecase.banner

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.BannerDomain
import kotlinx.coroutines.flow.Flow

interface BannerUseCase {

    fun getBanner(): Flow<Resource<List<BannerDomain>>>
}