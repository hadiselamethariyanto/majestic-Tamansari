package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsDomain(
    val id:String,
    val title: String,
    val createdDate: Long,
    val photo: String,
    val content: String,
    val totalComments: Int,
    val totalLikes: Int,
    val category:String
) : Parcelable