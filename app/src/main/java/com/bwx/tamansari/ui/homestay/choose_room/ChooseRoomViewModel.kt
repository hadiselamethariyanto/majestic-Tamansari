package com.bwx.tamansari.ui.homestay.choose_room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.HomestayUseCase

class ChooseRoomViewModel(private val homestayUseCase: HomestayUseCase) : ViewModel() {

    fun getAvailabilityRooms(idHomestay: String) =
        homestayUseCase.getAvailabilityRooms(idHomestay, "2022-11-20", "2022-11-21").asLiveData()
}