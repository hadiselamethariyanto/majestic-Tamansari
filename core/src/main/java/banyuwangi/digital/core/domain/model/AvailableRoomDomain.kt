package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AvailableRoomDomain(
    val id: String,
    val name: String,
    val price: Int,
    val area: Int,
    val capacity: Int,
    val bedType: String,
    val breakfast: Boolean,
    val roomsAvailable: Int,
    val photos: List<String>
):Parcelable