package banyuwangi.digital.core.data.wisata.repository.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetWisataRatingResponse(
    val success: Boolean,
    val message: String,
    val data: List<RatingWisataItem>
)

data class RatingWisataItem(
    val id: String,
    val username: String,
    val comment: String,
    val rating: Float,
    @field:SerializedName("id_wisata") val idWisata: String,
    @field:SerializedName("created_date") val createdDate: String,
    @field:SerializedName("updated_date") val updatedDate: String,
    @field:SerializedName("photo_profile_url") val photoProfileUrl: String
)