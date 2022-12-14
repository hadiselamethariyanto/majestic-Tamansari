package banyuwangi.digital.core.domain.usecase.homestay

import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.AvailableRoomDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import kotlinx.coroutines.flow.Flow

interface HomestayUseCase {

    fun getHomestay(): Flow<Resource<List<HomestayDomain>>>

    fun getDetailHomestay(idHomestay: String): Flow<Resource<HomestayDomain>>

    fun getAvailabilityRooms(
        idHomestay: String,
        checkin: String,
        checkout: String
    ): Flow<Resource<List<AvailableRoomDomain>>>
}