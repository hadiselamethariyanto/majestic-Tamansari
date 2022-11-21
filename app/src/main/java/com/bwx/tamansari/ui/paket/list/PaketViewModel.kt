package com.bwx.tamansari.ui.paket.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.TravelPackageUseCase

class PaketViewModel(private val useCase: TravelPackageUseCase) : ViewModel() {

    fun getTravelPackage() = useCase.getTravelPackage().asLiveData()
}