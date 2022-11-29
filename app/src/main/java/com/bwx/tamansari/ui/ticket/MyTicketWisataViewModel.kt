package com.bwx.tamansari.ui.ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.transaction_wisata.TransactionWisataUsecase

class MyTicketWisataViewModel(private val transactionWisataUsecase: TransactionWisataUsecase) :
    ViewModel() {

    fun getTransactionWisata(id: String) =
        transactionWisataUsecase.getTransactionWisata(id).asLiveData()
}