package banyuwangi.digital.core.data.homestay.mapper

import banyuwangi.digital.core.data.homestay.repository.source.remote.response.AvailableRoomItem
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.FacilityItem
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.HomestayItem
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.RoomItem
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import banyuwangi.digital.core.domain.model.FacilityDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.model.RoomDomain

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
                checkOut = it.checkOut,
                rooms = mapRoomItemToDomain(it.rooms),
                facilities = mapFacilitiesItemToDomain(it.facilities)
            )
        }

    fun mapFacilitiesItemToDomain(facilities: List<FacilityItem>): List<FacilityDomain> =
        facilities.map {
            FacilityDomain(name = it.name, iconUrl = it.url)
        }

    fun mapRoomItemToDomain(rooms: List<RoomItem>): List<RoomDomain> = rooms.map {
        RoomDomain(
            id = it.id,
            name = it.name,
            area = it.area,
            roomCapacity = it.capacity,
            bedType = it.bedType,
            breakfast = it.breakfast == 1,
            price = it.price
        )
    }

    fun mapAvailableRoomItemToDomain(rooms: List<AvailableRoomItem>): List<AvailableRoomDomain> =
        rooms.map {
            AvailableRoomDomain(
                id = it.id,
                name = it.name,
                price = it.price,
                area = it.area,
                capacity = it.capacity,
                bedType = it.bedType,
                breakfast = it.breakfast == 1,
                roomsAvailable = it.roomsAvailable,
                photos = it.photos
            )
        }
}