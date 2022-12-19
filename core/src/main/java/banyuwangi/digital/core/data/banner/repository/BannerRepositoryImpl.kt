package banyuwangi.digital.core.data.banner.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.banner.mapper.BannerMapper
import banyuwangi.digital.core.data.banner.repository.source.remote.BannerRemoteDataSource
import banyuwangi.digital.core.data.banner.repository.source.remote.response.GetBannerResponse
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.domain.model.BannerDomain
import banyuwangi.digital.core.domain.repository.BannerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BannerRepositoryImpl(private val remoteDataSource: BannerRemoteDataSource) :
    BannerRepository {

    override fun getBanner(): Flow<Resource<List<BannerDomain>>> {
        return object : NetworkOnlyResource<List<BannerDomain>, GetBannerResponse>() {
            override fun loadFromNetwork(data: GetBannerResponse): Flow<List<BannerDomain>> {
                val response = BannerMapper.mapBannerItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetBannerResponse>> =
                remoteDataSource.getBanner()

        }.asFlow()
    }


}