package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomestayDomain(
    val id: String,
    val nama: String,
    val jarak: Double,
    val harga: Int,
    val rating: Float,
    val totalReview: Int,
    val star: Float,
    val foto: List<String>,
    val checkIn: String,
    val checkOut: String,
    val longitude: Double,
    val latitude: Double,
    val address: String,
    val facilities: List<FacilityDomain>
) : Parcelable