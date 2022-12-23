package banyuwangi.digital.core.domain.usecase.wisata

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.model.WisataRatingDomain
import banyuwangi.digital.core.domain.repository.WisataRepository
import kotlinx.coroutines.flow.Flow

class WisataInteractor(private val repository: WisataRepository) : WisataUseCase {
    override fun getWisata(): Flow<Resource<List<WisataDomain>>> = repository.getWisata()

    override fun getDetailWisata(idWisata: String): Flow<Resource<WisataDomain>> =
        repository.getDetailWisata(idWisata)

    override fun getWisataRating(idWisata: String): Flow<Resource<List<WisataRatingDomain>>> =
        repository.getWisataRating(idWisata)

    override fun deleteTicket(
        idWisata: String,
        id: String
    ): Flow<Resource<List<TicketWisataDomain>>> = repository.deleteTicketWisata(idWisata, id)

    override fun addTicket(
        idWisata: String,
        name: String,
        price: String
    ): Flow<Resource<List<TicketWisataDomain>>> = repository.addTicketWisata(idWisata, name, price)
}