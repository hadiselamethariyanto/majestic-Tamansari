package com.bwx.tamansari.ui.wisata.review

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import banyuwangi.digital.core.domain.usecase.TransactionWisataUsecase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class ReviewWisataViewModel(
    private val authUseCase: AuthUseCase,
    private val transactionWisataUseCase: TransactionWisataUsecase
) : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }

    fun insertTransactionWisata(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idWisata: String
    ) = transactionWisataUseCase.insertTransactionWisata(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idWisata
    ).asLiveData()

}