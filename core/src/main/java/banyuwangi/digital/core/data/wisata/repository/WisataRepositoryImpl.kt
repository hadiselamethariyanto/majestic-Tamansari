package banyuwangi.digital.core.data.wisata.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.wisata.mapper.WisataMapper
import banyuwangi.digital.core.data.wisata.repository.source.remote.WisataRemoteDataSource
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataResponse
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.repository.WisataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class WisataRepositoryImpl(private val remoteDataSource: WisataRemoteDataSource) :
    WisataRepository {

    override fun getWisata(): Flow<Resource<List<WisataDomain>>> {
        return object : NetworkOnlyResource<List<WisataDomain>, GetWisataResponse>() {
            override fun loadFromNetwork(data: GetWisataResponse): Flow<List<WisataDomain>> {
                val wisatas = WisataMapper.mapWisataResponseToDomain(data.data)
                return flowOf(wisatas)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetWisataResponse>> =
                remoteDataSource.getWisata()

        }.asFlow()
    }

}