package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FacilityDomain(val name: String, val iconUrl: String) : Parcelable