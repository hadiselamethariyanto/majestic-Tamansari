package banyuwangi.digital.core.data.travel_package.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetTravelPackageResponse(
    val success: Boolean,
    val message: String,
    val data: List<TravelPackageItem>
)

data class TravelPackageItem(
    val id: String,
    val name: String,
    val rating: Float,
    @field:SerializedName("vote_count") val voteCount: Int,
    @field:SerializedName("total_sold") val totalSold: Int,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    @field:SerializedName("meeting_point") val meetingPoint: String,
    val photos: List<String>,
    val itinerary: List<ItineraryItem>,
    @field:SerializedName("travel_package_types") val travelPackageTypes: List<TravelPackageTypeItem>
)