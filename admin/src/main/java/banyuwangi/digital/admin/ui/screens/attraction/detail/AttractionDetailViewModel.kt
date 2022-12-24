package banyuwangi.digital.admin.ui.screens.attraction.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banyuwangi.digital.admin.utils.Utils.fromJson
import banyuwangi.digital.core.data.Resource
import banyuwangi.digital.core.domain.model.TicketWisataDomain
import banyuwangi.digital.core.domain.model.WisataDomain
import banyuwangi.digital.core.domain.usecase.wisata.WisataUseCase
import kotlinx.coroutines.launch
import java.io.File

class AttractionDetailViewModel(
    private val wisataUseCase: WisataUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(AttractionDetailState())
    var selectedTicket by mutableStateOf(TicketWisataDomain(id = "", name = "", price = 0))

    init {
        savedStateHandle.get<String>("data").let { data ->
            val attraction = data?.fromJson(WisataDomain::class.java)
            state = state.copy(
                tickets = attraction?.tickets ?: arrayListOf(),
                photos = attraction?.photos ?: arrayListOf()
            )
        }
    }

    fun deleteTicket(idWisata: String, id: String) = viewModelScope.launch {
        wisataUseCase.deleteTicket(idWisata, id).collect { res ->
            state = when (res) {
                is Resource.Loading -> {
                    state.copy(isTicketLoading = true)
                }
                is Resource.Success -> {
                    state.copy(tickets = res.data ?: arrayListOf(), isTicketLoading = false)
                }
                is Resource.Error -> {
                    state.copy(isTicketLoading = false)
                }
            }
        }
    }

    fun addTicket(idWisata: String) = viewModelScope.launch {
        wisataUseCase.addTicket(idWisata, selectedTicket.name, selectedTicket.price.toString())
            .collect { res ->
                state = when (res) {
                    is Resource.Loading -> {
                        state.copy(isTicketLoading = true)
                    }
                    is Resource.Success -> {
                        state.copy(tickets = res.data ?: arrayListOf(), isTicketLoading = false)
                    }
                    is Resource.Error -> {
                        state.copy(isTicketLoading = false)
                    }
                }
            }
    }

    fun editTicket(idWisata: String) = viewModelScope.launch {
        wisataUseCase.editTicket(
            idWisata,
            selectedTicket.name,
            selectedTicket.price.toString(),
            selectedTicket.id
        ).collect { res ->
            state = when (res) {
                is Resource.Loading -> {
                    state.copy(isTicketLoading = true)
                }
                is Resource.Success -> {
                    state.copy(tickets = res.data ?: arrayListOf(), isTicketLoading = false)
                }
                is Resource.Error -> {
                    state.copy(isTicketLoading = false)
                }
            }
        }
    }

    fun deletePhoto(idWisata: String, url: String) = viewModelScope.launch {
        wisataUseCase.deletePhoto(idWisata, url).collect { res ->
            state = when (res) {
                is Resource.Loading -> {
                    state.copy(isPhotoLoading = true)
                }
                is Resource.Success -> {
                    state.copy(isPhotoLoading = false, photos = res.data ?: arrayListOf())
                }
                is Resource.Error -> {
                    state.copy(isPhotoLoading = false)
                }
            }
        }
    }

    fun addPhoto(idWisata: String, file: File) = viewModelScope.launch {
        wisataUseCase.addPhoto(idWisata, file).collect { res ->
            state = when (res) {
                is Resource.Loading -> {
                    state.copy(isPhotoLoading = true)
                }
                is Resource.Success -> {
                    state.copy(isPhotoLoading = false, photos = res.data ?: arrayListOf())
                }
                is Resource.Error -> {
                    state.copy(isPhotoLoading = false)
                }
            }
        }
    }

    fun updateSelectedTicket(id: String, name: String, price: String) {
        selectedTicket = selectedTicket.copy(id = id, name = name, price = price.toInt())
    }

    fun updateTicketName(name: String) {
        selectedTicket = selectedTicket.copy(name = name)
    }

    fun updateTicketPrice(price: String) {
        selectedTicket = selectedTicket.copy(price = if (price.isNotEmpty()) price.toInt() else 0)
    }
}