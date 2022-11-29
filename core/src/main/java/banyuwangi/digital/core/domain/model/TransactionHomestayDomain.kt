package banyuwangi.digital.core.domain.model

data class TransactionHomestayDomain(
    val homestay: HomestayDomain,
    val checkIn: String,
    val checkOut: String,
    val totalPerson: Int
)