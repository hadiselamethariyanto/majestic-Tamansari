package banyuwangi.digital.core.data.tpsr.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetTpsrBalanceResponse(
    val success: Boolean,
    val message: String,
    val data: TpsrBalanceItem
)

data class TpsrBalanceItem(val saldo: Int? = null, val history: List<HistoryTpsrItem>? = null)

data class HistoryTpsrItem(
    val id: String? = null,
    val fee: Int? = null,
    val type: Int? = null,
    @field:SerializedName("created_date") val createdDate: Long? = null
)
