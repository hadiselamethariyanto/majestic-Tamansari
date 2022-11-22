package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.RestaurantDomain
import kotlinx.coroutines.flow.Flow

interface RestaurantUseCase {

    fun getRestaurants(): Flow<Resource<List<RestaurantDomain>>>
}