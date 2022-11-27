package com.bwx.tamansari.ui.payment.choose_payment_method

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodUseCase
import banyuwangi.digital.core.domain.usecase.transaction_wisata.TransactionWisataUsecase

class ChoosePaymentMethodViewModel(
    private val paymentMethodUseCase: PaymentMethodUseCase,
    private val transactionWisataUsecase: TransactionWisataUsecase
) :
    ViewModel() {

    fun getPaymentMethod() = paymentMethodUseCase.getPaymentMethod().asLiveData()

    fun getTransactionWisata(id: String) =
        transactionWisataUsecase.getTransactionWisata(id).asLiveData()
}