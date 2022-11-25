package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
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
        idWisata: String
    ): Flow<Resource<Boolean>> = repository.insertTransactionWisata(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idWisata
    )
}