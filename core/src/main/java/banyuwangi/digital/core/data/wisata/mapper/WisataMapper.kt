package banyuwangi.digital.core.data.wisata.mapper

import banyuwangi.digital.core.data.wisata.repository.source.remote.response.RatingWisataItem
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.TicketWisataItem
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.WisataItem
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain

object WisataMapper {

    fun mapWisataResponseToDomain(wisatas: List<WisataItem>): List<WisataDomain> = wisatas.map {
        WisataDomain(
            id = it.id ?: "",
            name = it.name ?: "",
            photos = it.photos ?: arrayListOf(),
            rating = it.rating ?: 0f,
            voteCount = it.voteCount ?: 0,
            latitude = it.latitude ?: 0.0,
            longitude = it.longitude ?: 0.0,
            description = it.description ?: "",
            tickets = mapTicketWisataItemToDomain(it.tickets ?: arrayListOf())
        )
    }

    fun mapWisataResponseToDomain(it: WisataItem): WisataDomain = WisataDomain(
        id = it.id ?: "",
        name = it.name ?: "",
        photos = it.photos ?: arrayListOf(),
        rating = it.rating ?: 0f,
        voteCount = it.voteCount ?: 0,
        latitude = it.latitude ?: 0.0,
        longitude = it.longitude ?: 0.0,
        description = it.description ?: "",
        tickets = mapTicketWisataItemToDomain(it.tickets ?: arrayListOf())
    )

    fun mapTicketWisataItemToDomain(tickets: List<TicketWisataItem>): List<TicketWisataDomain> =
        tickets.map {
            TicketWisataDomain(
                id = it.id,
                name = it.name,
                price = it.price
            )
        }

    fun mapWisataRatingItemToDomain(ratings: List<RatingWisataItem>): List<WisataRatingDomain> =
        ratings.map {
            WisataRatingDomain(
                id = it.id,
                username = it.username,
                comment = it.comment,
                rating = it.rating,
                idWisata = it.idWisata,
                createdDate = it.createdDate,
                updatedDate = it.updatedDate,
                photoProfileUrl = it.photoProfileUrl
            )
        }
}