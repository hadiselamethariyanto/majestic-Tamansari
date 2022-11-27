package banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response

import banyuwangi.digital.core.data.transactions.repository.source.remote.response.TransactionItem

data class InsertTransactionWisataResponse(
    val success: Boolean,
    val message: String,
    val data: TransactionItem
)
