package banyuwangi.digital.core.data.travel_package.mapper

import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.ItineraryItem
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.TravelPackageItem
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.TravelPackageTypeItem
import banyuwangi.digital.core.domain.model.ItineraryDomain
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import banyuwangi.digital.core.domain.model.TravelPackageTypeDomain

object TravelPackageMapper {

    fun mapTravelPackageItemToDomain(packages: List<TravelPackageItem>): List<TravelPackageDomain> =
        packages.map {
            TravelPackageDomain(
                id = it.id,
                name = it.name,
                rating = it.rating,
                voteCount = it.voteCount,
                totalSold = it.totalSold,
                latitude = it.latitude,
                longitude = it.longitude,
                address = it.address,
                meetingPoint = it.meetingPoint,
                photos = it.photos,
                itinerary = mapItineraryItemToDomain(it.itinerary),
                travelPackageType = mapTravelPackageTypeItemToDomain(it.travelPackageTypes)
            )
        }

    private fun mapItineraryItemToDomain(itineraries: List<ItineraryItem>): List<ItineraryDomain> =
        itineraries.map {
            ItineraryDomain(time = it.time, description = it.description)
        }

    private fun mapTravelPackageTypeItemToDomain(types: List<TravelPackageTypeItem>): List<TravelPackageTypeDomain> =
        types.map {
            TravelPackageTypeDomain(
                id = it.id,
                name = it.name,
                price = it.price,
                detail = it.detail
            )
        }
}