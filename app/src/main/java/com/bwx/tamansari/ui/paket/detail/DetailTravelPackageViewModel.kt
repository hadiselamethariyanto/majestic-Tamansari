package com.bwx.tamansari.ui.paket.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.travel_package.TravelPackageUseCase

class DetailTravelPackageViewModel(private val travelPackageUseCase: TravelPackageUseCase) :
    ViewModel() {

    fun getDetailTravelPackage(id: String) =
        travelPackageUseCase.getDetailTravelPackage(id).asLiveData()

}