package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WisataDomain(
    val id:String,
    val nama: String,
    val foto: String,
    val rating: Float,
    val vote_count: Int,
    val latitude: Double,
    val longitude: Double,
    val description: String
) : Parcelable