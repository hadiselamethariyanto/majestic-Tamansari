package com.bwx.tamansari.ui.peta

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.maps.MapsUseCase

class MapsViewModel(private val mapsUseCase: MapsUseCase) : ViewModel() {

    fun getMapsOutlet() = mapsUseCase.getMapsOutlet().asLiveData()
}