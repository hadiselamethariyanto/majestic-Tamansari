package banyuwangi.digital.core.domain.usecase.transaction_homestay

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import kotlinx.coroutines.flow.Flow

interface TransactionHomestayUseCase {

    fun insertTransactionHomestay(
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
    ): Flow<Resource<TransactionDomain>>

}