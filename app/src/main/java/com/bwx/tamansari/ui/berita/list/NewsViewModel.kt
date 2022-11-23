package com.bwx.tamansari.ui.berita.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.NewsUseCase

class NewsViewModel(private val newsUseCase: NewsUseCase) : ViewModel() {

    fun getNews() = newsUseCase.getNews().asLiveData()
}