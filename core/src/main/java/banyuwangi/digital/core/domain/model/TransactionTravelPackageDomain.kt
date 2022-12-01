package banyuwangi.digital.core.domain.model

data class TransactionTravelPackageDomain(
    val travelPackage: TravelPackageDomain,
    val travelPackageType: TravelPackageTypeDomain,
    val selectedDate: String
)