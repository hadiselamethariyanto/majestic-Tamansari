package banyuwangi.digital.core.data.travel_package.repository.source.remote.response

data class GetDetailTravelPackageResponse(
    val success: Boolean,
    val message: String,
    val data: TravelPackageItem
)