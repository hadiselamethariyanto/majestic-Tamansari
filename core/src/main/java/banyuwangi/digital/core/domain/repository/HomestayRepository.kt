package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.HomestayDomain
import kotlinx.coroutines.flow.Flow

interface HomestayRepository {

    fun getHomestay(): Flow<Resource<List<HomestayDomain>>>
}