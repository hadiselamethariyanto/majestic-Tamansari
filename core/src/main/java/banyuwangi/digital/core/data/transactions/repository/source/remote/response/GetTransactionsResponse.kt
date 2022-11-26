package banyuwangi.digital.core.data.transactions.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetTransactionsResponse(
    val success: Boolean,
    val message: String,
    val data: List<TransactionItem>
)

data class TransactionItem(
    val id: String? = null,
    @field:SerializedName("customer_name")
    val customerName: String? = null,
    @field:SerializedName("customer_email")
    val customerEmail: String? = null,
    @field:SerializedName("customer_phone_number")
    val customerPhoneNumber: String? = null,
    val status: Int? = 0,
    val fee: Int? = 0,
    @field:SerializedName("convenience_fee")
    val convenienceFee: Int? = 0,
    @field:SerializedName("total_fee")
    val totalFee: Int? = 0,
    val type: Int? = 0,
    val title: String? = null,
    @field:SerializedName("sub_title")
    val subTitle: String? = null
)
