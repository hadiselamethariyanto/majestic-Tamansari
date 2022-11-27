package banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response

import banyuwangi.digital.core.data.wisata.repository.source.remote.response.WisataItem

data class GetTransactionWisataResponse(
    val success: Boolean,
    val message: String,
    val data: TransactionWisataResponse
)

data class TransactionWisataResponse(
    val wisata: WisataItem,
    val detail: List<ChartItem>
)