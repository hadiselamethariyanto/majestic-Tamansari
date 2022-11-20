package banyuwangi.digital.core.data.homestay.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.homestay.mapper.HomestayMapper
import banyuwangi.digital.core.data.homestay.repository.source.remote.HomestayRemoteDataSource
import banyuwangi.digital.core.data.homestay.repository.source.remote.response.GetHomestayResponse
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.repository.HomestayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HomestayRepositoryImpl(private val remoteDataSource: HomestayRemoteDataSource) :
    HomestayRepository {
    override fun getHomestay(): Flow<Resource<List<HomestayDomain>>> {
        return object : NetworkOnlyResource<List<HomestayDomain>, GetHomestayResponse>() {
            override fun loadFromNetwork(data: GetHomestayResponse): Flow<List<HomestayDomain>> {
                val homestays = HomestayMapper.mapHomestayItemToDomain(data.data)
                return flowOf(homestays)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetHomestayResponse>> =
                remoteDataSource.getHomestay()

        }.asFlow()
    }

}