package banyuwangi.digital.core.data.restoran.mapper

import banyuwangi.digital.core.data.restoran.repository.source.remote.response.RestaurantItem
import banyuwangi.digital.core.data.restoran.repository.source.remote.response.RestaurantMenuItem
import banyuwangi.digital.core.domain.model.MenuRestaurantDomain
import banyuwangi.digital.core.domain.model.RestaurantDomain

object RestaurantMapper {

    fun mapRestaurantItemToDomain(list: List<RestaurantItem>): List<RestaurantDomain> = list.map {
        RestaurantDomain(
            id = it.id,
            name = it.name,
            category = it.category,
            latitude = it.latitude,
            longitude = it.longitude,
            photoUrl = it.photoUrl,
            rating = it.rating,
            voteCount = it.voteCount,
            menus = mapMenuItemToDomain(it.menus)
        )
    }

    private fun mapMenuItemToDomain(menus: List<RestaurantMenuItem>): List<MenuRestaurantDomain> =
        menus.map {
            MenuRestaurantDomain(
                id = it.id,
                name = it.name,
                price = it.price,
                photoUrl = it.photoUrl
            )
        }
}