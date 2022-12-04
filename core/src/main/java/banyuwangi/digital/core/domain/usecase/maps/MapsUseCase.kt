package banyuwangi.digital.core.domain.usecase.maps

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import kotlinx.coroutines.flow.Flow

interface MapsUseCase {

    fun getMapsOutlet(): Flow<Resource<List<MapsOutletDomain>>>

}