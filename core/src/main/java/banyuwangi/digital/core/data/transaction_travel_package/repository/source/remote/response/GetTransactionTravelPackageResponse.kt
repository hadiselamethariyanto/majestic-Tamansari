package banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.response

import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.TravelPackageItem
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.TravelPackageTypeItem
import com.google.gson.annotations.SerializedName

data class GetTransactionTravelPackageResponse(
    val success: Boolean,
    val message: String,
    val data: TransactionTravelPackageItem
)

data class TransactionTravelPackageItem(
    @field:SerializedName("travel_package") val travelPackage: TravelPackageItem,
    @field:SerializedName("travel_package_type") val travelPackageTypeItem: TravelPackageTypeItem,
    @field:SerializedName("selected_date") val selectedDate: String
)