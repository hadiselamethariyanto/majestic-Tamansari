package banyuwangi.digital.core.domain.usecase.transactions

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.repository.TransactionsRepository
import kotlinx.coroutines.flow.Flow

class TransactionsInteractor(private val repository: TransactionsRepository) : TransactionsUseCase {
    override fun getTransactions(email: String): Flow<Resource<List<TransactionDomain>>> =
        repository.getTransactions(email)
}