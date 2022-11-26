package banyuwangi.digital.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionDomain(
    val id: String,
    val customerName: String,
    val customerEmail: String,
    val customerPhoneNumber: String,
    val status: Int,
    val fee: Int,
    val convenienceFee: Int,
    val totalFee: Int,
    val type: Int,
    val title:String,
    val subTitle:String
) : Parcelable