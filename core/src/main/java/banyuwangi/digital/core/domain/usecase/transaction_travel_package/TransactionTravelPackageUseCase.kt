package banyuwangi.digital.core.domain.usecase.transaction_travel_package

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.model.TransactionTravelPackageDomain
import kotlinx.coroutines.flow.Flow

interface TransactionTravelPackageUseCase {

    fun insertTransactionTravelPackage(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idTravelPackage: String,
        idTravelPackageType: String,
        selectedDate: String
    ): Flow<Resource<TransactionDomain>>

    fun getTransactionTravelPackage(id:String):Flow<Resource<TransactionTravelPackageDomain>>

}