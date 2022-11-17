package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelPackageDomain(
    val id: String,
    val idPaket: String,
    val name: String,
    val price: Int,
    val detail: String
) : Parcelable