package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.BannerDomain
import kotlinx.coroutines.flow.Flow

interface BannerRepository {

    fun getBanner(): Flow<Resource<List<BannerDomain>>>
}