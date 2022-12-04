package banyuwangi.digital.core.domain.model

data class TpsrBalanceDomain(val saldo: Int, val history: List<HistoryTpsrDomain>)

data class HistoryTpsrDomain(val id: String, val fee: Int, val type: Int, val createdDate: Long)