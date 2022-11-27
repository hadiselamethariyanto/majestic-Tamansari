package banyuwangi.digital.core.domain.usecase.transaction_wisata

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionWisataDomain
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
        charts: List<ChartDomain>
    ): Flow<Resource<TransactionDomain>>

    fun getTransactionWisata(id: String): Flow<Resource<TransactionWisataDomain>>

}