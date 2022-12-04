package com.bwx.tamansari.ui.homestay.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.homestay.HomestayUseCase

class DetailHomestayViewModel(private val homestayUseCase: HomestayUseCase) : ViewModel() {

    fun getDetailHomestay(idHomestay: String) =
        homestayUseCase.getDetailHomestay(idHomestay).asLiveData()
}