package com.bwx.tamansari.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.banner.BannerUseCase

class HomeViewModel(private val bannerUseCase: BannerUseCase) : ViewModel() {

    fun getBanner() = bannerUseCase.getBanner().asLiveData()

}