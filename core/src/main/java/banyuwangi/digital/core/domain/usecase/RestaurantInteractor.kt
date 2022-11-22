package banyuwangi.digital.core.domain.usecase

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.RestaurantDomain
import banyuwangi.digital.core.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow

class RestaurantInteractor(private val repository: RestaurantRepository) : RestaurantUseCase {

    override fun getRestaurants(): Flow<Resource<List<RestaurantDomain>>> =
        repository.getRestaurant()
}