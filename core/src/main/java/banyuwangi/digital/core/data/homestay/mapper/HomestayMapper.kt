package banyuwangi.digital.core.data.homestay.mapper

import banyuwangi.digital.core.data.homestay.repository.source.remote.response.HomestayItem
import banyuwangi.digital.core.domain.model.HomestayDomain

object HomestayMapper {

    fun mapHomestayItemToDomain(homestays: List<HomestayItem>): List<HomestayDomain> =
        homestays.map {
            HomestayDomain(
                id = it.id,
                name = it.name,
                rating = it.rating,
                voteCount = it.voteCount,
                latitude = it.latitude,
                longitude = it.longitude,
                description = it.description,
                address = it.address,
                photos = it.photos,
                checkIn = it.checkIn,
                checkOut = it.checkOut
            )
        }
}