package banyuwangi.digital.core.domain.usecase.search

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import banyuwangi.digital.core.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchInteractor(private val repository: SearchRepository) : SearchUseCase {
    override fun search(keyword: String): Flow<Resource<List<MapsOutletDomain>>> =
        repository.search(keyword)
}