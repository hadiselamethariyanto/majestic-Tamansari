package com.bwx.tamansari.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.usecase.auth.AuthUseCase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class LoginViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val _user = MutableLiveData<Resource<FirebaseUser>?>()
    val user: LiveData<Resource<FirebaseUser>?> get() = _user

    private val _formState = MutableLiveData<LoginFormState>()
    val formState: LiveData<LoginFormState> get() = _formState

    fun login(authCredential: AuthCredential) = viewModelScope.launch {
        _user.value = authUseCase.login(authCredential)
    }

    fun loginWithEmailPassword(email:String, password: String) = viewModelScope.launch {
        _user.value = authUseCase.loginWithEmail(email, password)
    }

    fun formDataChanged(email: String, password: String) {
        if (email.isEmpty()) {
            _formState.value = LoginFormState(emailError = 0)
        } else if (password.isEmpty()) {
            _formState.value = LoginFormState(passwordError = 0)
        } else {
            _formState.value = LoginFormState(isDataValid = true)
        }
    }

}