package banyuwangi.digital.core.domain.model

data class MapsOutletDomain(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val type: Int,
    val typeName:String,
    val rating:Float,
    val voteCount:Int,
    val photos: List<String>
)
