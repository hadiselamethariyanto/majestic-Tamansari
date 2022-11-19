package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.WisataDomain
import kotlinx.coroutines.flow.Flow

interface WisataRepository {

    fun getWisata(): Flow<Resource<List<WisataDomain>>>
}