package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import kotlinx.coroutines.flow.Flow

interface TravelPackageUseCase {
    fun getTravelPackage(): Flow<Resource<List<TravelPackageDomain>>>
}