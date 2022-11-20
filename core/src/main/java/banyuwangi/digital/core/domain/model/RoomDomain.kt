package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoomDomain(
    val id: String,
    val name: String,
    val area: Int,
    val roomCapacity: Int,
    val bedType: String,
    val breakfast: Boolean,
    val price: Int
):Parcelable