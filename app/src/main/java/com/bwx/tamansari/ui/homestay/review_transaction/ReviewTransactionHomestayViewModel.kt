package com.bwx.tamansari.ui.homestay.review_transaction

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import banyuwangi.digital.core.domain.usecase.transaction_homestay.TransactionHomestayUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class ReviewTransactionHomestayViewModel(
    private val authUseCase: AuthUseCase,
    private val transactionHomestayUseCase: TransactionHomestayUseCase
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
        idHomestay: String,
        idRoom: String,
        checkIn: String,
        checkOut: String,
        totalPerson: Int
    ) = transactionHomestayUseCase.insertTransactionHomestay(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idHomestay,
        idRoom,
        checkIn,
        checkOut,
        totalPerson
    ).asLiveData()

}