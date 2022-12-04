package banyuwangi.digital.core.data.peta.mapper

import banyuwangi.digital.core.data.peta.repository.source.remote.response.MapsOutletItem
import banyuwangi.digital.core.domain.model.MapsOutletDomain

object MapsMapper {

    fun mapMapsOutletItemToDomain(list: List<MapsOutletItem>): List<MapsOutletDomain> = list.map {
        MapsOutletDomain(
            id = it.id ?: "",
            name = it.name ?: "",
            latitude = it.latitude ?: 0.0,
            longitude = it.longitude ?: 0.0,
            address = it.address ?: "",
            type = it.type ?: 0,
            typeName = it.typeName?:"",
            rating = it.rating?:0f,
            voteCount = it.voteCount?:0,
            photos = it.photos ?: arrayListOf()
        )
    }
}