package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.ChartDomain
import kotlinx.coroutines.flow.Flow

interface TransactionWisataRepository {

    fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String,
        charts:List<ChartDomain>
    ): Flow<Resource<Boolean>>
}