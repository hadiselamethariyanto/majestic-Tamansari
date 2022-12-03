package banyuwangi.digital.core.data.transaction_wisata.mapper

import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.ChartItem
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.response.TransactionWisataResponse
import banyuwangi.digital.core.data.wisata.mapper.WisataMapper
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.TransactionWisataDomain

object TransactionWisataMapper {

    fun mapTransactionWisataResponseToDomain(data: TransactionWisataResponse): TransactionWisataDomain =
        TransactionWisataDomain(
            wisata = WisataMapper.mapWisataResponseToDomain(data.wisata),
            detail = mapChartItemToDomain(data.detail)
        )

     fun mapChartItemToDomain(data: List<ChartItem>): List<ChartDomain> = data.map {
        ChartDomain(
            idProduct = it.id,
            productName = it.name,
            productPrice = it.fee,
            total = it.total
        )
    }
}