package com.bwx.tamansari.ui.homestay.choose_room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import banyuwangi.digital.core.domain.usecase.homestay.HomestayUseCase
import com.bwx.tamansari.utils.DoubleTrigger

class ChooseRoomViewModel(private val homestayUseCase: HomestayUseCase) : ViewModel() {

    private val _firstDate = MutableLiveData<String>()
    private val _lastDate = MutableLiveData<String>()

    fun setFirstDate(date: String) {
        _firstDate.value = date
    }

    fun setLastDate(date: String) {
        _lastDate.value = date
    }

    fun getAvailabilityRooms(idHomestay: String) =
        DoubleTrigger(_firstDate, _lastDate).switchMap { mediatorState ->
            mediatorState.first?.let { firstDate ->
                mediatorState.second?.let { lastDate ->
                    homestayUseCase.getAvailabilityRooms(idHomestay, firstDate, lastDate)
                        .asLiveData()
                }
            }
        }
}