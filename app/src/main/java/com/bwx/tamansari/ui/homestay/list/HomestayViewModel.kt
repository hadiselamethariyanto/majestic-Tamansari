package com.bwx.tamansari.ui.homestay.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.HomestayUseCase

class HomestayViewModel(private val homestayUseCase: HomestayUseCase) : ViewModel() {

    fun getHomestay() = homestayUseCase.getHomestay().asLiveData()
}