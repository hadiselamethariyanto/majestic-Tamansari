package com.bwx.tamansari.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.search.SearchUseCase

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {

    fun search(keyword: String) = searchUseCase.search(keyword).asLiveData()

}