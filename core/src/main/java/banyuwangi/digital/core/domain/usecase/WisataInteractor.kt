package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.repository.WisataRepository
import kotlinx.coroutines.flow.Flow

class WisataInteractor(private val repository: WisataRepository) : WisataUseCase {
    override fun getWisata(): Flow<Resource<List<WisataDomain>>> = repository.getWisata()
}