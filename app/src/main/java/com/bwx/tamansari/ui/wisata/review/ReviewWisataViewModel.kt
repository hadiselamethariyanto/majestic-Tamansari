package com.bwx.tamansari.ui.wisata.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class ReviewWisataViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }

}