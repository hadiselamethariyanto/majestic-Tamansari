package com.bwx.tamansari.ui.ticket.travel_package

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.transaction_travel_package.TransactionTravelPackageUseCase

class MyTicketTravelPackageViewModel(private val transactionTravelPackageUseCase: TransactionTravelPackageUseCase) :
    ViewModel() {

    fun getTransactionTravelPackage(id: String) =
        transactionTravelPackageUseCase.getTransactionTravelPackage(id).asLiveData()
}