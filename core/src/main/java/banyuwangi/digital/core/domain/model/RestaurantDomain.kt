package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantDomain(
    val id: String,
    val name: String,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val photoUrl: String,
    val rating: Float,
    val voteCount: Int,
    val menus: List<MenuRestaurantDomain>
) : Parcelable