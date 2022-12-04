package banyuwangi.digital.core.domain.usecase.maps

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import banyuwangi.digital.core.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow

class MapsInteractor(private val repository: MapsRepository) : MapsUseCase {
    override fun getMapsOutlet(): Flow<Resource<List<MapsOutletDomain>>> =
        repository.getMapsOutlet()
}