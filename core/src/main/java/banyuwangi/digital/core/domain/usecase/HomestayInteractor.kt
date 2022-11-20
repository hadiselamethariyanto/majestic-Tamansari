package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.repository.HomestayRepository
import kotlinx.coroutines.flow.Flow

class HomestayInteractor(private val repository: HomestayRepository) : HomestayUseCase {
    override fun getHomestay(): Flow<Resource<List<HomestayDomain>>> = repository.getHomestay()
}