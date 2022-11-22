package com.bwx.tamansari.ui.restaurant.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.RestaurantUseCase

class RestaurantViewModel(private val restaurantUseCase: RestaurantUseCase) : ViewModel() {

    fun getRestaurant() = restaurantUseCase.getRestaurants().asLiveData()

}