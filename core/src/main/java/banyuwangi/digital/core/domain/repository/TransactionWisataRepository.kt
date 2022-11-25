package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface TransactionWisataRepository {

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