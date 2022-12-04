package banyuwangi.digital.core.domain.usecase.tpsr

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain
import kotlinx.coroutines.flow.Flow

interface TpsrUseCase {

    fun getTpsrBalance(email: String): Flow<Resource<TpsrBalanceDomain>>

}