package banyuwangi.digital.core.domain.model

data class WisataRatingDomain(
    val id: String,
    val username: String,
    val comment: String,
    val rating: Float,
    val idWisata: String,
    val createdDate: String,
    val updatedDate: String,
    val photoProfileUrl: String
)
