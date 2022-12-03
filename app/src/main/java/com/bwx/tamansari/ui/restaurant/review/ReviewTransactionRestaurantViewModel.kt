package com.bwx.tamansari.ui.restaurant.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.usecase.HomestayUseCase

class ReviewTransactionRestaurantViewModel(private val homestayUseCase: HomestayUseCase) :
    ViewModel() {

    private val _dataHomestays = MutableLiveData<List<HomestayDomain>>()
    val dataHomestays: LiveData<List<HomestayDomain>> get() = _dataHomestays

    private val _selectedHomestay = MutableLiveData<HomestayDomain>()
    val selectedHomestay: LiveData<HomestayDomain> get() = _selectedHomestay

    fun getHomestays() = homestayUseCase.getHomestay().asLiveData()

    fun setDataHomestays(data: List<HomestayDomain>) {
        _dataHomestays.value = data
    }

    fun setSelectedHomestay(homestayDomain: HomestayDomain){
        _selectedHomestay.value = homestayDomain
    }
}