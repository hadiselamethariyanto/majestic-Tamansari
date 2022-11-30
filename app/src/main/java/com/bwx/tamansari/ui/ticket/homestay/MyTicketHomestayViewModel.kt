package com.bwx.tamansari.ui.ticket.homestay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.transaction_homestay.TransactionHomestayUseCase

class MyTicketHomestayViewModel(private val transactionHomestayUseCase: TransactionHomestayUseCase) :
    ViewModel() {

    fun getTransactionHomestay(id: String) =
        transactionHomestayUseCase.getTransactionHomestay(id).asLiveData()
}