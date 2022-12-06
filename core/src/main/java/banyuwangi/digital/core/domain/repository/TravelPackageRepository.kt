package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import kotlinx.coroutines.flow.Flow

interface TravelPackageRepository {

    fun getTravelPackage(): Flow<Resource<List<TravelPackageDomain>>>

    fun getDetailTravelPackage(id: String): Flow<Resource<TravelPackageDomain>>
}