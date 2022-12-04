package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain
import kotlinx.coroutines.flow.Flow

interface TpsrRepository {

    fun getTpsrBalance(email:String): Flow<Resource<TpsrBalanceDomain>>
}