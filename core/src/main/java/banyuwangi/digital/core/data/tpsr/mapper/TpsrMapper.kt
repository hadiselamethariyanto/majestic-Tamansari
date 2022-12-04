package banyuwangi.digital.core.data.tpsr.mapper

import banyuwangi.digital.core.data.tpsr.repository.source.remote.response.HistoryTpsrItem
import banyuwangi.digital.core.data.tpsr.repository.source.remote.response.TpsrBalanceItem
import banyuwangi.digital.core.domain.model.HistoryTpsrDomain
import banyuwangi.digital.core.domain.model.TpsrBalanceDomain

object TpsrMapper {

    fun mapTpsrBalanceItemToDomain(data: TpsrBalanceItem): TpsrBalanceDomain =
        TpsrBalanceDomain(
            saldo = data.saldo ?: 0,
            history = mapTpsrHistoryItemToDomain(data.history ?: arrayListOf())
        )

    private fun mapTpsrHistoryItemToDomain(data: List<HistoryTpsrItem>): List<HistoryTpsrDomain> =
        data.map {
            HistoryTpsrDomain(
                id = it.id ?: "",
                fee = it.fee ?: 0,
                type = it.type ?: 0,
                createdDate = it.createdDate ?: 0
            )
        }
}