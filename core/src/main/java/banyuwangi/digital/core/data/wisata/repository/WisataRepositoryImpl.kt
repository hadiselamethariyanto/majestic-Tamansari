package banyuwangi.digital.core.data.wisata.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.data.mechanism.NetworkOnlyResource
import banyuwangi.digital.core.data.network.ApiResponseOnly
import banyuwangi.digital.core.data.wisata.mapper.WisataMapper
import banyuwangi.digital.core.data.wisata.repository.source.remote.WisataRemoteDataSource
import banyuwangi.digital.core.data.wisata.repository.source.remote.response.*
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain
import banyuwangi.digital.core.domain.repository.WisataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.io.File

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

    override fun getDetailWisata(idWisata: String): Flow<Resource<WisataDomain>> {
        return object : NetworkOnlyResource<WisataDomain, GetDetailWisataResponse>() {
            override fun loadFromNetwork(data: GetDetailWisataResponse): Flow<WisataDomain> {
                val response = WisataMapper.mapWisataResponseToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<GetDetailWisataResponse>> =
                remoteDataSource.getDetailWisata(idWisata)

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

    override fun deleteTicketWisata(
        idWisata: String,
        id: String
    ): Flow<Resource<List<TicketWisataDomain>>> {
        return object :
            NetworkOnlyResource<List<TicketWisataDomain>, DeleteTicketWisataResponse>() {
            override fun loadFromNetwork(data: DeleteTicketWisataResponse): Flow<List<TicketWisataDomain>> {
                val response = WisataMapper.mapTicketWisataItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<DeleteTicketWisataResponse>> =
                remoteDataSource.deleteTicket(idWisata, id)

        }.asFlow()
    }

    override fun addTicketWisata(
        idWisata: String,
        name: String,
        price: String
    ): Flow<Resource<List<TicketWisataDomain>>> {
        return object :
            NetworkOnlyResource<List<TicketWisataDomain>, DeleteTicketWisataResponse>() {
            override fun loadFromNetwork(data: DeleteTicketWisataResponse): Flow<List<TicketWisataDomain>> {
                val response = WisataMapper.mapTicketWisataItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<DeleteTicketWisataResponse>> =
                remoteDataSource.addTicket(idWisata, name, price)

        }.asFlow()
    }

    override fun editTicketWisata(
        idWisata: String,
        name: String,
        price: String,
        id: String
    ): Flow<Resource<List<TicketWisataDomain>>> {
        return object :
            NetworkOnlyResource<List<TicketWisataDomain>, DeleteTicketWisataResponse>() {
            override fun loadFromNetwork(data: DeleteTicketWisataResponse): Flow<List<TicketWisataDomain>> {
                val response = WisataMapper.mapTicketWisataItemToDomain(data.data)
                return flowOf(response)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<DeleteTicketWisataResponse>> =
                remoteDataSource.editTicket(idWisata, name, price, id)

        }.asFlow()
    }

    override fun deletePhoto(idWisata: String, url: String): Flow<Resource<List<String>>> {
        return object : NetworkOnlyResource<List<String>, DeletePhotoWisataResponse>() {
            override fun loadFromNetwork(data: DeletePhotoWisataResponse): Flow<List<String>> {
                return flowOf(data.data)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<DeletePhotoWisataResponse>> =
                remoteDataSource.deletePhoto(idWisata, url)

        }.asFlow()
    }

    override fun addPhoto(idWisata: String, file: File): Flow<Resource<List<String>>> {
        return object : NetworkOnlyResource<List<String>, DeletePhotoWisataResponse>() {
            override fun loadFromNetwork(data: DeletePhotoWisataResponse): Flow<List<String>> {
                return flowOf(data.data)
            }

            override suspend fun createCall(): Flow<ApiResponseOnly<DeletePhotoWisataResponse>> =
                remoteDataSource.addPhoto(idWisata, file)

        }.asFlow()
    }

}