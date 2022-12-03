package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartRestaurantDomain(
    val idProduct: String,
    val productName: String,
    val productPrice: Int,
    var total: Int,
    var imgProduct: String
) : Parcelable