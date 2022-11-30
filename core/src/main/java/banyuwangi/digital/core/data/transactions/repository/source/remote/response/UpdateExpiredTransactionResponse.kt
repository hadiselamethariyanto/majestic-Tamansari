package banyuwangi.digital.core.data.transactions.repository.source.remote.response

data class UpdateExpiredTransactionResponse(
    val success: Boolean,
    val message: String,
    val data: TransactionItem
)
