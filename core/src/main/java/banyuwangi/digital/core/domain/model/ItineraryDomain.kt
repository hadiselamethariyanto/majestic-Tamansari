package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItineraryDomain(val time: String, val description: String) : Parcelable
