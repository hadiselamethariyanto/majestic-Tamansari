package banyuwangi.digital.core.domain.usecase.banner

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.BannerDomain
import banyuwangi.digital.core.domain.repository.BannerRepository
import kotlinx.coroutines.flow.Flow

class BannerInteractor(private val repository: BannerRepository) : BannerUseCase {
    override fun getBanner(): Flow<Resource<List<BannerDomain>>> = repository.getBanner()
}