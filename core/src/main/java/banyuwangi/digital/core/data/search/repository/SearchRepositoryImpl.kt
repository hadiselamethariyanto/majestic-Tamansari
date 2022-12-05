package banyuwangi.digital.core.data.search.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.peta.mapper.MapsMapper
import banyuwangi.digital.core.data.peta.repository.source.remote.response.GetMapsOutletResponse
import banyuwangi.digital.core.data.search.repository.source.remote.SearchRemoteDataSource
import banyuwangi.digital.core.domain.model.MapsOutletDomain
import banyuwangi.digital.core.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SearchRepositoryImpl(private val remoteDataSource: SearchRemoteDataSource) :
    SearchRepository {

    override fun search(keyword: String): Flow<Resource<List<MapsOutletDomain>>> {
        return object : NetworkOnlyResource<List<MapsOutletDomain>, GetMapsOutletResponse>() {
            override fun loadFromNetwork(data: GetMapsOutletResponse): Flow<List<MapsOutletDomain>> {
                val response = MapsMapper.mapMapsOutletItemToDomain(data.data ?: arrayListOf())
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetMapsOutletResponse>> =
                remoteDataSource.search(keyword)

        }.asFlow()
    }

}