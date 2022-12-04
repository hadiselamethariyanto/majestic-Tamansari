package banyuwangi.digital.core.data.peta.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetMapsOutletResponse(
    val success: Boolean,
    val message: String,
    val data: List<MapsOutletItem>? = arrayListOf()
)

data class MapsOutletItem(
    val id: String? = null,
    val name: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val address: String? = null,
    val type: Int? = null,
    @field:SerializedName("type_name") val typeName: String? = null,
    val rating: Float? = null,
    @field:SerializedName("vote_count") val voteCount: Int? = null,
    val photos: List<String>? = arrayListOf()
)
