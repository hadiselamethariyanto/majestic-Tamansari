package banyuwangi.digital.core.domain.usecase.homestay

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.repository.HomestayRepository
import kotlinx.coroutines.flow.Flow

class HomestayInteractor(private val repository: HomestayRepository) : HomestayUseCase {

    override fun getHomestay(): Flow<Resource<List<HomestayDomain>>> = repository.getHomestay()

    override fun getDetailHomestay(idHomestay: String): Flow<Resource<HomestayDomain>> =
        repository.getDetailHomestay(idHomestay)

    override fun getAvailabilityRooms(
        idHomestay: String,
        checkin: String,
        checkout: String
    ): Flow<Resource<List<AvailableRoomDomain>>> =
        repository.getAvailabilityRooms(idHomestay, checkin, checkout)
}