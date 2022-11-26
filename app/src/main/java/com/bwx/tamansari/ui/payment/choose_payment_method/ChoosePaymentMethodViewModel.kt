package com.bwx.tamansari.ui.payment.choose_payment_method

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodUseCase

class ChoosePaymentMethodViewModel(private val paymentMethodUseCase: PaymentMethodUseCase) :
    ViewModel() {

    fun getPaymentMethod() = paymentMethodUseCase.getPaymentMethod().asLiveData()
}