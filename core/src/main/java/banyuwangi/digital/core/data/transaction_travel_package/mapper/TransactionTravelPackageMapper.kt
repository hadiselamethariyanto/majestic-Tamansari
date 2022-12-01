package banyuwangi.digital.core.data.transaction_travel_package.mapper

import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.response.TransactionTravelPackageItem
import banyuwangi.digital.core.data.travel_package.mapper.TravelPackageMapper
import banyuwangi.digital.core.domain.model.TransactionTravelPackageDomain

object TransactionTravelPackageMapper {
    fun mapTransactionTravelPackageItemToDomain(data: TransactionTravelPackageItem): TransactionTravelPackageDomain =
        TransactionTravelPackageDomain(
            travelPackage = TravelPackageMapper.mapTravelPackageItemToDomain(
                data.travelPackage
            ),
            travelPackageType = TravelPackageMapper.mapTravelPackageTypeItemToDomain(data.travelPackageTypeItem),
            selectedDate = data.selectedDate
        )
}