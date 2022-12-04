package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.RestaurantDomain
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getRestaurant(): Flow<Resource<List<RestaurantDomain>>>

    fun getDetailRestaurant(idRestaurant: String): Flow<Resource<RestaurantDomain>>
}