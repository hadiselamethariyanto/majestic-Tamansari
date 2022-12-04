package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import kotlinx.coroutines.flow.Flow

interface MapsRepository {

    fun getMapsOutlet(): Flow<Resource<List<MapsOutletDomain>>>
}