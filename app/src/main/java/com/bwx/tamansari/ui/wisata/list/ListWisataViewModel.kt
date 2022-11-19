package com.bwx.tamansari.ui.wisata.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.WisataUseCase

class ListWisataViewModel(private val useCase: WisataUseCase) : ViewModel() {

    fun getWisata() = useCase.getWisata().asLiveData()

}