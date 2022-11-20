package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain
import kotlinx.coroutines.flow.Flow

interface WisataUseCase {

    fun getWisata(): Flow<Resource<List<WisataDomain>>>

    fun getWisataRating(idWisata: String): Flow<Resource<List<WisataRatingDomain>>>
}