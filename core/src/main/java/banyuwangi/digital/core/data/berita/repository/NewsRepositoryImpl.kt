package banyuwangi.digital.core.data.berita.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.berita.mapper.NewsMapper
import banyuwangi.digital.core.data.berita.repository.source.remote.NewsRemoteDataSource
import banyuwangi.digital.core.data.berita.repository.source.remote.response.GetNewsResponse
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.domain.model.NewsDomain
import banyuwangi.digital.core.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NewsRepositoryImpl(private val remoteDataSource: NewsRemoteDataSource) : NewsRepository {
    override fun getNews(): Flow<Resource<List<NewsDomain>>> {
        return object : NetworkOnlyResource<List<NewsDomain>, GetNewsResponse>() {
            override fun loadFromNetwork(data: GetNewsResponse): Flow<List<NewsDomain>> {
                val response = NewsMapper.mapNewsItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetNewsResponse>> =
                remoteDataSource.getNews()

        }.asFlow()
    }
}