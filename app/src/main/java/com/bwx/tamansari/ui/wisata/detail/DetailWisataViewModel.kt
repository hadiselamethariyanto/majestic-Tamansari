package com.bwx.tamansari.ui.wisata.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.wisata.WisataUseCase

class DetailWisataViewModel(private val wisataUseCase: WisataUseCase) : ViewModel() {

    fun getDetailWisata(idWisata: String) = wisataUseCase.getDetailWisata(idWisata).asLiveData()
}