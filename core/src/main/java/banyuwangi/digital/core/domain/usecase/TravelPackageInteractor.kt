package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import banyuwangi.digital.core.domain.repository.TravelPackageRepository
import kotlinx.coroutines.flow.Flow

class TravelPackageInteractor(private val repository: TravelPackageRepository) :
    TravelPackageUseCase {
    override fun getTravelPackage(): Flow<Resource<List<TravelPackageDomain>>> =
        repository.getTravelPackage()
}