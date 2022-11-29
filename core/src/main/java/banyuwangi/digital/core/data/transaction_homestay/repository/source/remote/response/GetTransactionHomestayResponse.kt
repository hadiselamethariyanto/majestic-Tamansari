package banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.response

import banyuwangi.digital.core.data.homestay.repository.source.remote.response.HomestayItem
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.RoomItem
import com.google.gson.annotations.SerializedName

data class GetTransactionHomestayResponse(
    val success: Boolean,
    val message: String,
    val data: TransactionHomestayItem
)

data class TransactionHomestayItem(
    val homestay: HomestayItem,
    @field:SerializedName("check_in") val checkIn: String,
    @field:SerializedName("check_out") val checkOut: String,
    @field:SerializedName("total_person") val totalPerson: Int,
    val room: RoomItem
)
