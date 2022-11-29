package banyuwangi.digital.core.domain.usecase.transaction_homestay

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionHomestayDomain
import banyuwangi.digital.core.domain.repository.TransactionHomestayRepository
import kotlinx.coroutines.flow.Flow

class TransactionHomestayInteractor(private val repository: TransactionHomestayRepository) :
    TransactionHomestayUseCase {
    override fun insertTransactionHomestay(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRoom: String,
        checkIn: String,
        checkOut: String,
        totalPerson: Int
    ): Flow<Resource<TransactionDomain>> = repository.insertTransactionHomestay(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idHomestay,
        idRoom,
        checkIn,
        checkOut,
        totalPerson
    )

    override fun getTransactionHomestay(id: String): Flow<Resource<TransactionHomestayDomain>> {
        return repository.getTransactionHomestay(id)
    }
}