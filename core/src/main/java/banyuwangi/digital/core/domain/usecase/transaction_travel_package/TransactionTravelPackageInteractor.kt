package banyuwangi.digital.core.domain.usecase.transaction_travel_package

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TransactionDomain
import banyuwangi.digital.core.domain.repository.TransactionTravelPackageRepository
import kotlinx.coroutines.flow.Flow

class TransactionTravelPackageInteractor(private val repository: TransactionTravelPackageRepository) :
    TransactionTravelPackageUseCase {
    override fun insertTransactionTravelPackage(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idTravelPackage: String,
        idTravelPackageType: String,
        selectedDate: String
    ): Flow<Resource<TransactionDomain>> = repository.insertTransactionTravelPackage(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idTravelPackage,
        idTravelPackageType,
        selectedDate
    )
}