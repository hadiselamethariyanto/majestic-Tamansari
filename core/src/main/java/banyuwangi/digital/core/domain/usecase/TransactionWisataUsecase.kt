package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface TransactionWisataUsecase {

    fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String
    ): Flow<Resource<Boolean>>

}