package com.bwx.tamansari.ui.wisata.detail.rating

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.wisata.WisataUseCase

class RatingWisataViewModel(private val wisataUseCase: WisataUseCase) : ViewModel() {

    fun getWisataRating(idWisata: String) = wisataUseCase.getWisataRating(idWisata).asLiveData()

}