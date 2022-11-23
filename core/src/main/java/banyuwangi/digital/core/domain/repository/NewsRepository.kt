package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.NewsDomain
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(): Flow<Resource<List<NewsDomain>>>
}