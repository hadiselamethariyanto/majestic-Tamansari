package banyuwangi.digital.core.domain.usecase.tpsr

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain
import banyuwangi.digital.core.domain.repository.TpsrRepository
import kotlinx.coroutines.flow.Flow

class TpsrInteractor(private val repository: TpsrRepository) : TpsrUseCase {

    override fun getTpsrBalance(email: String): Flow<Resource<TpsrBalanceDomain>> =
        repository.getTpsrBalance(email)

}