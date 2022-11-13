package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaketWisataModel(
    val nama: String,
    val harga: Int,
    val rating: Float,
    val photos: List<String>,
    val totalReview: Int,
    val totalSold: Int,
    val itineraries: List<ItineraryDomain>,
    val longitude: Double,
    val latitude: Double,
    val address: String
) : Parcelable