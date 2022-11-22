package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuRestaurantDomain(
    val id: String,
    val photoUrl: String,
    val name: String,
    val price: Int
) : Parcelable