package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItineraryDomain(val id: String, val time: String, val description: String) : Parcelable
