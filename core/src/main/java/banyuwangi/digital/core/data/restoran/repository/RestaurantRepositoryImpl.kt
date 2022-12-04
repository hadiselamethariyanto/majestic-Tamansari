package banyuwangi.digital.core.data.restoran.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.restoran.mapper.RestaurantMapper
import banyuwangi.digital.core.data.restoran.repository.source.remote.RestaurantRemoteDataSource
import banyuwangi.digital.core.data.restoran.repository.source.remote.response.GetDetailRestaurantResponse
import banyuwangi.digital.core.data.restoran.repository.source.remote.response.GetRestaurantResponse
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.model.RestaurantDomain
import banyuwangi.digital.core.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RestaurantRepositoryImpl(private val remoteDataSource: RestaurantRemoteDataSource) :
    RestaurantRepository {

    override fun getRestaurant(): Flow<Resource<List<RestaurantDomain>>> {
        return object : NetworkOnlyResource<List<RestaurantDomain>, GetRestaurantResponse>() {
            override fun loadFromNetwork(data: GetRestaurantResponse): Flow<List<RestaurantDomain>> {
                val restaurants = RestaurantMapper.mapRestaurantItemToDomain(data.data)
                return flowOf(restaurants)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetRestaurantResponse>> =
                remoteDataSource.getRestaurant()

        }.asFlow()
    }

    override fun getDetailRestaurant(idRestaurant: String): Flow<Resource<RestaurantDomain>> {
        return object : NetworkOnlyResource<RestaurantDomain, GetDetailRestaurantResponse>() {
            override fun loadFromNetwork(data: GetDetailRestaurantResponse): Flow<RestaurantDomain> {
                val response = RestaurantMapper.mapRestaurantItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetDetailRestaurantResponse>> =
                remoteDataSource.getDetailRestaurant(idRestaurant)

        }.asFlow()
    }

}