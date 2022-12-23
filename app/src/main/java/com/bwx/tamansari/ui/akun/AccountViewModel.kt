package com.bwx.tamansari.ui.akun

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.usecase.auth.AuthUseCase
import banyuwangi.digital.core.domain.usecase.tpsr.TpsrUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class AccountViewModel(private val authUseCase: AuthUseCase, private val tpsrUseCase: TpsrUseCase) :
    ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()
        _user.value = null
    }

    fun getTpsrBalance(email: String) = tpsrUseCase.getTpsrBalance(email).asLiveData()

}