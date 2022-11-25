package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.ChartDomain
import kotlinx.coroutines.flow.Flow

interface TransactionWisataUsecase {

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