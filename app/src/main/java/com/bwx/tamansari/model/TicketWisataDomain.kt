package com.bwx.tamansari.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TicketWisataDomain(val id: String, val name: String, val price: Int):Parcelable