package banyuwangi.digital.core.data.wisata.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.wisata.mapper.WisataMapper
import banyuwangi.digital.core.data.wisata.repository.source.remote.WisataRemoteDataSource
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataRatingResponse
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.GetWisataResponse
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain
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

    override fun getWisataRating(idWisata: String): Flow<Resource<List<WisataRatingDomain>>> {
        return object : NetworkOnlyResource<List<WisataRatingDomain>, GetWisataRatingResponse>() {
            override fun loadFromNetwork(data: GetWisataRatingResponse): Flow<List<WisataRatingDomain>> {
                val ratings = WisataMapper.mapWisataRatingItemToDomain(data.data)
                return flowOf(ratings)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetWisataRatingResponse>> =
                remoteDataSource.getWisataRating(idWisata)

        }.asFlow()
    }

}