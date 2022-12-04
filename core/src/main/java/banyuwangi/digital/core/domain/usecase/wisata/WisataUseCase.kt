package banyuwangi.digital.core.domain.usecase.wisata

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain
import kotlinx.coroutines.flow.Flow

interface WisataUseCase {

    fun getWisata(): Flow<Resource<List<WisataDomain>>>

    fun getDetailWisata(idWisata: String): Flow<Resource<WisataDomain>>

    fun getWisataRating(idWisata: String): Flow<Resource<List<WisataRatingDomain>>>
}