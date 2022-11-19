package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WisataDomain(
    val id: String,
    val name: String,
    val photos: List<String>,
    val rating: Float,
    val voteCount: Int,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val tickets: List<TicketWisataDomain>? = arrayListOf()
) : Parcelable