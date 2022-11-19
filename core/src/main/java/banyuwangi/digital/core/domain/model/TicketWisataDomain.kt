package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TicketWisataDomain(val id: String, val name: String, val price: Int) : Parcelable