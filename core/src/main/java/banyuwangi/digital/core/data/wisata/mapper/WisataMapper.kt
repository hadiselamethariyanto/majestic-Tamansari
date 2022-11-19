package banyuwangi.digital.core.data.wisata.mapper

import banyuwangi.digital.core.data.wisata.repository.source.remote.response.WisataItem
import banyuwangi.digital.core.domain.model.WisataDomain

object WisataMapper {

    fun mapWisataResponseToDomain(wisatas: List<WisataItem>): List<WisataDomain> = wisatas.map {
        WisataDomain(
            id = it.id,
            name = it.name,
            photos = it.photos,
            rating = it.rating,
            voteCount = it.voteCount,
            latitude = it.latitude,
            longitude = it.longitude,
            description = it.description
        )
    }
}