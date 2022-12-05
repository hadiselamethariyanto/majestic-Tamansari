package banyuwangi.digital.core.domain.usecase.search

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {

    fun search(keyword: String): Flow<Resource<List<MapsOutletDomain>>>

}