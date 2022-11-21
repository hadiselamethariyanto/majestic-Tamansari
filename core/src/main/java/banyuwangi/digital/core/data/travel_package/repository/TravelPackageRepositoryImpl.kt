package banyuwangi.digital.core.data.travel_package.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.travel_package.mapper.TravelPackageMapper
import banyuwangi.digital.core.data.travel_package.repository.source.remote.TravelPackageRemoteDataSource
import banyuwangi.digital.core.data.travel_package.repository.source.remote.response.GetTravelPackageResponse
import banyuwangi.digital.core.domain.model.TravelPackageDomain
import banyuwangi.digital.core.domain.repository.TravelPackageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TravelPackageRepositoryImpl(private val remoteDataSource: TravelPackageRemoteDataSource) :
    TravelPackageRepository {

    override fun getTravelPackage(): Flow<Resource<List<TravelPackageDomain>>> {
        return object : NetworkOnlyResource<List<TravelPackageDomain>, GetTravelPackageResponse>() {
            override fun loadFromNetwork(data: GetTravelPackageResponse): Flow<List<TravelPackageDomain>> {
                val packages = TravelPackageMapper.mapTravelPackageItemToDomain(data.data)
                return flowOf(packages)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetTravelPackageResponse>> =
                remoteDataSource.getTravelPackage()

        }.asFlow()
    }
}