package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelPackageDomain(
    val id: String,
    val name: String,
    val rating: Float,
    val voteCount: Int,
    val totalSold: Int,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val meetingPoint: String,
    val photos: List<String>,
    val itinerary: List<ItineraryDomain>,
    val travelPackageType: List<TravelPackageTypeDomain>
) : Parcelable