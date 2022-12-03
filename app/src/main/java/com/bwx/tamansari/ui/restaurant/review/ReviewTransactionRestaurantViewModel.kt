package com.bwx.tamansari.ui.restaurant.review

import androidx.lifecycle.*
import banyuwangi.digital.core.domain.model.CartRestaurantDomain
import banyuwangi.digital.core.domain.model.ChartDomain
import banyuwangi.digital.core.domain.model.HomestayDomain
import banyuwangi.digital.core.domain.usecase.AuthUseCase
import banyuwangi.digital.core.domain.usecase.HomestayUseCase
import banyuwangi.digital.core.domain.usecase.transaction_restaurant.TransactionRestaurantUseCase
import com.bwx.tamansari.R
import com.bwx.tamansari.ui.wisata.review.UserFormState
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class ReviewTransactionRestaurantViewModel(
    private val homestayUseCase: HomestayUseCase,
    private val authUseCase: AuthUseCase,
    private val transactionRestaurantUseCase: TransactionRestaurantUseCase
) :
    ViewModel() {

    private val _userFormState = MutableLiveData<UserFormState>()
    val userFormState: LiveData<UserFormState> get() = _userFormState

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?> get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = authUseCase.currentUser
    }

    private val _dataHomestays = MutableLiveData<List<HomestayDomain>>()
    val dataHomestays: LiveData<List<HomestayDomain>> get() = _dataHomestays

    private val _selectedHomestay = MutableLiveData<HomestayDomain>()
    val selectedHomestay: LiveData<HomestayDomain> get() = _selectedHomestay

    fun getHomestays() = homestayUseCase.getHomestay().asLiveData()

    fun setDataHomestays(data: List<HomestayDomain>) {
        _dataHomestays.value = data
    }

    fun setSelectedHomestay(homestayDomain: HomestayDomain) {
        _selectedHomestay.value = homestayDomain
    }

    fun userDataChanged(username: String, phoneNumber: String) {
        if (username.isEmpty()) {
            _userFormState.value = UserFormState(username = R.string.warning_empty_username)
        } else if (phoneNumber.isEmpty() || phoneNumber.length < 11) {
            _userFormState.value = UserFormState(phoneNumber = R.string.warning_empty_phone_number)
        } else {
            _userFormState.value = UserFormState(isDataValid = true)
        }
    }

    fun insertTransactionRestaurant(
        customerName: String,
        customerEmail: String,
        customerPhoneNumber: String,
        fee: Int,
        convenienceFee: Int,
        totalFee: Int,
        idHomestay: String,
        idRestaurant: String,
        carts: List<CartRestaurantDomain>,
        ongkir:Int
    ) = transactionRestaurantUseCase.insertTransaction(
        customerName,
        customerEmail,
        customerPhoneNumber,
        fee,
        convenienceFee,
        totalFee,
        idHomestay,
        idRestaurant,
        carts,
        ongkir
    ).asLiveData()
}