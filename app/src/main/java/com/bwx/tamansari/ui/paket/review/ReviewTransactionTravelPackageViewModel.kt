package com.bwx.tamansari.ui.paket.review

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import banyuwangi.digital.core.domain.usecase.transaction_travel_package.TransactionTravelPackageUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class ReviewTransactionTravelPackageViewModel(
    private val authUseCase: AuthUseCase,
    private val transactionTravelPackageUseCase: TransactionTravelPackageUseCase
) : ViewModel() {
    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }

    fun insertTransaction(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idTravelPackage: String,
        idTravelPackageType: String,
        selectedDate: String
    ) = transactionTravelPackageUseCase.insertTransactionTravelPackage(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idTravelPackage,
        idTravelPackageType,
        selectedDate
    ).asLiveData()

}