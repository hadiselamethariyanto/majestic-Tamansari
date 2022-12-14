package banyuwangi.digital.core.domain.repository

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain
import kotlinx.coroutines.flow.Flow
import java.io.File

interface WisataRepository {

    fun getWisata(): Flow<Resource<List<WisataDomain>>>

    fun getDetailWisata(idWisata: String): Flow<Resource<WisataDomain>>

    fun getWisataRating(idWisata: String): Flow<Resource<List<WisataRatingDomain>>>

    fun deleteTicketWisata(idWisata: String, id: String): Flow<Resource<List<TicketWisataDomain>>>

    fun addTicketWisata(
        idWisata: String,
        name: String,
        price: String
    ): Flow<Resource<List<TicketWisataDomain>>>

    fun editTicketWisata(
        idWisata: String,
        name: String,
        price: String,
        id: String
    ): Flow<Resource<List<TicketWisataDomain>>>

    fun deletePhoto(idWisata: String, url: String): Flow<Resource<List<String>>>

    fun addPhoto(idWisata: String, file:File):Flow<Resource<List<String>>>
}