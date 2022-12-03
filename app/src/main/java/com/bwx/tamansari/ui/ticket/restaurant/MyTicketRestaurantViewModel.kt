package com.bwx.tamansari.ui.ticket.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.transaction_restaurant.TransactionRestaurantUseCase

class MyTicketRestaurantViewModel(private val transactionRestaurantUseCase: TransactionRestaurantUseCase) :
    ViewModel() {

    fun getTransactionRestaurant(id: String) =
        transactionRestaurantUseCase.getTransactionRestaurant(id).asLiveData()
}