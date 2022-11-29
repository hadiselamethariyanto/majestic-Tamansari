package banyuwangi.digital.core.data.transaction_homestay.mapper

import banyuwangi.digital.core.data.homestay.mapper.HomestayMapper
import banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.response.TransactionHomestayItem
import banyuwangi.digital.core.domain.model.TransactionHomestayDomain

object TransactionHomestayMapper {

    fun mapTransactionHomestayItemToDomain(trx: TransactionHomestayItem): TransactionHomestayDomain =
        TransactionHomestayDomain(
            homestay = HomestayMapper.mapHomestayItemToDomain(trx.homestay),
            checkIn = trx.checkIn,
            checkOut = trx.checkOut,
            totalPerson = trx.totalPerson,
            room = HomestayMapper.mapRoomItemToDomain(trx.room)
        )
}