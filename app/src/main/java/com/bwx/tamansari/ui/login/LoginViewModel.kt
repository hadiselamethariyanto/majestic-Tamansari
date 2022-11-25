package com.bwx.tamansari.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class LoginViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val _user = MutableLiveData<Resource<FirebaseUser>?>()
    val user: LiveData<Resource<FirebaseUser>?> get() = _user

    fun login(authCredential: AuthCredential) = viewModelScope.launch {
        _user.value = authUseCase.login(authCredential)
    }

}