package com.bwx.tamansari.ui.payment.choose_payment_method

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import banyuwangi.digital.core.domain.model.PaymentMethodDomain
import banyuwangi.digital.core.domain.usecase.payment.PaymentUseCase
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodUseCase
import banyuwangi.digital.core.domain.usecase.transaction_homestay.TransactionHomestayUseCase
import banyuwangi.digital.core.domain.usecase.transaction_restaurant.TransactionRestaurantUseCase
import banyuwangi.digital.core.domain.usecase.transaction_travel_package.TransactionTravelPackageUseCase
import banyuwangi.digital.core.domain.usecase.transaction_wisata.TransactionWisataUsecase

class ChoosePaymentMethodViewModel(
    private val paymentMethodUseCase: PaymentMethodUseCase,
    private val transactionWisataUsecase: TransactionWisataUsecase,
    private val transactionHomestayUseCase: TransactionHomestayUseCase,
    private val transactionTravelPackageUseCase: TransactionTravelPackageUseCase,
    private val transactionRestaurantUseCase: TransactionRestaurantUseCase,
    private val paymentUseCase: PaymentUseCase
) :
    ViewModel() {

    private val _selectedPaymentMethod = MutableLiveData<PaymentMethodDomain?>()
    val selectedPaymentMethod: LiveData<PaymentMethodDomain?> get() = _selectedPaymentMethod

    fun getPaymentMethod() = paymentMethodUseCase.getPaymentMethod().asLiveData()

    fun getTransactionWisata(id: String) =
        transactionWisataUsecase.getTransactionWisata(id).asLiveData()

    fun getTransactionHomestay(id: String) =
        transactionHomestayUseCase.getTransactionHomestay(id).asLiveData()

    fun getTransactionTravelPackage(id: String) =
        transactionTravelPackageUseCase.getTransactionTravelPackage(id).asLiveData()

    fun getTransactionRestaurant(id: String) =
        transactionRestaurantUseCase.getTransactionRestaurant(id).asLiveData()

    fun selectPaymentMethod(paymentMethod: PaymentMethodDomain) {
        _selectedPaymentMethod.value = paymentMethod
    }

    fun chargeEWallet(orderId: String, channelCode: String, amount: Int) =
        paymentUseCase.chargeEWallet(orderId, channelCode, amount).asLiveData()

}