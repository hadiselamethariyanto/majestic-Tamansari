package banyuwangi.digital.core.data.transactions.mapper

import banyuwangi.digital.core.data.transactions.repository.source.remote.response.TransactionItem
import banyuwangi.digital.core.domain.model.TransactionDomain

object TransactionsMapper {

    fun mapTransactionsItemToDomain(list: List<TransactionItem>): List<TransactionDomain> =
        list.map {
            TransactionDomain(
                id = it.id ?: "",
                customerName = it.customerName ?: "",
                customerEmail = it.customerEmail ?: "",
                customerPhoneNumber = it.customerPhoneNumber ?: "",
                status = it.status ?: 0,
                fee = it.fee ?: 0,
                convenienceFee = it.convenienceFee ?: 0,
                totalFee = it.totalFee ?: 0,
                type = it.type ?: 0,
                title = it.title ?: "",
                subTitle = it.subTitle ?: ""
            )
        }
}