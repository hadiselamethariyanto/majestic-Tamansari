package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomestayDomain(
    val id: String,
    val name: String,
    val rating: Float,
    val voteCount: Int,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val address: String,
    val photos: List<String>,
    val checkIn: String,
    val checkOut: String,
    val rooms: List<RoomDomain>,
    val facilities: List<FacilityDomain>
) : Parcelable
