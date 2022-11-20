package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.HomestayDomain
import kotlinx.coroutines.flow.Flow

interface HomestayUseCase {

    fun getHomestay(): Flow<Resource<List<HomestayDomain>>>
}