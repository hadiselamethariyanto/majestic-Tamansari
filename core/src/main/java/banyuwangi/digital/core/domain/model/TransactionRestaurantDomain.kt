package banyuwangi.digital.core.domain.model

data class TransactionRestaurantDomain(
    val restaurant: RestaurantDomain,
    val homestay: HomestayDomain,
    val ongkir: Int,
    val detail:List<ChartDomain>
)
