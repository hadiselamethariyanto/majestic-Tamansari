package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.NewsDomain
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {

    fun getNews(): Flow<Resource<List<NewsDomain>>>
}