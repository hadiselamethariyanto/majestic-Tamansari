package com.bwx.tamansari.ui.tpsr

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import banyuwangi.digital.core.domain.usecase.tpsr.TpsrUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class TpsrViewModel(private val tpsrUseCase: TpsrUseCase, private val authUseCase: AuthUseCase) :
    ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }

    fun getTpsrBalance(email: String) = tpsrUseCase.getTpsrBalance(email).asLiveData()
}