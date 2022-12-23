package banyuwangi.digital.admin.ui.screens.attraction.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.usecase.wisata.WisataUseCase
import kotlinx.coroutines.launch

class AttractionViewModel(private val wisataUseCase: WisataUseCase) : ViewModel() {

    var state by mutableStateOf(AttractionState())

    init {
        viewModelScope.launch {
            wisataUseCase.getWisata().collect { res ->
                state = when (res) {
                    is Resource.Loading -> {
                        state.copy(isLoading = true, error = null)
                    }
                    is Resource.Success -> {
                        val data = res.data ?: arrayListOf()
                        state.copy(isLoading = false, error = null, data = data)
                    }
                    is Resource.Error -> {
                        state.copy(isLoading = false, error = res.message)
                    }
                }
            }
        }
    }
}