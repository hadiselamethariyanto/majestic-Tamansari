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
                subTitle = it.subTitle ?: "",
                expiredAt = it.expiredAt ?: 0,
                createdDate = it.createdDate ?: 0
            )
        }

    fun mapTransactionItemToDomain(data: TransactionItem): TransactionDomain = TransactionDomain(
        id = data.id ?: "",
        customerName = data.customerName ?: "",
        customerEmail = data.customerEmail ?: "",
        customerPhoneNumber = data.customerPhoneNumber ?: "",
        status = data.status ?: 0,
        fee = data.fee ?: 0,
        convenienceFee = data.convenienceFee ?: 0,
        totalFee = data.totalFee ?: 0,
        type = data.type ?: 0,
        title = data.title ?: "",
        subTitle = data.subTitle ?: "",
        expiredAt = data.expiredAt ?: 0,
        createdDate = data.createdDate ?: 0
    )
}