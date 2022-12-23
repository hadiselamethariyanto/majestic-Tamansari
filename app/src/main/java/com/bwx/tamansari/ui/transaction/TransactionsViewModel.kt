package com.bwx.tamansari.ui.transaction

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.usecase.auth.AuthUseCase
import banyuwangi.digital.core.domain.usecase.transactions.TransactionsUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class TransactionsViewModel(
    private val transactionsUseCase: TransactionsUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    fun getTransactions(email: String) = transactionsUseCase.getTransactions(email).asLiveData()

    fun updateExpiredTransaction(id: String) =
        transactionsUseCase.updateExpiredTransaction(id).asLiveData()

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }
}