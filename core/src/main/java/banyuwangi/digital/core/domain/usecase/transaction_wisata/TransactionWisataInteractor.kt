package banyuwangi.digital.core.domain.usecase.transaction_wisata

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionWisataDomain
import banyuwangi.digital.core.domain.repository.TransactionWisataRepository
import kotlinx.coroutines.flow.Flow

class TransactionWisataInteractor(private val repository: TransactionWisataRepository) :
    TransactionWisataUsecase {
    override fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String,
        charts: List<ChartDomain>
    ): Flow<Resource<TransactionDomain>> = repository.insertTransactionWisata(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idWisata,
        charts
    )

    override fun getTransactionWisata(id: String): Flow<Resource<TransactionWisataDomain>> =
        repository.getTransactionWisata(id)
}