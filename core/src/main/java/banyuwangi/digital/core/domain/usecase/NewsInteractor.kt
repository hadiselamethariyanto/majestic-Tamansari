package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.NewsDomain
import banyuwangi.digital.core.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsInteractor(private val repository: NewsRepository) : NewsUseCase {

    override fun getNews(): Flow<Resource<List<NewsDomain>>> = repository.getNews()

}