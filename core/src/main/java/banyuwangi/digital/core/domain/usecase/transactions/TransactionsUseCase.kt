package banyuwangi.digital.core.domain.usecase.transactions

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import kotlinx.coroutines.flow.Flow

interface TransactionsUseCase {

    fun getTransactions(email: String): Flow<Resource<List<TransactionDomain>>>
}