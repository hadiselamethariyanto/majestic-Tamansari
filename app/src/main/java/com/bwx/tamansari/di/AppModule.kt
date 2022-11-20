package com.bwx.tamansari.di

import banyuwangi.digital.core.domain.usecase.HomestayInteractor
import banyuwangi.digital.core.domain.usecase.HomestayUseCase
import banyuwangi.digital.core.domain.usecase.WisataInteractor
import banyuwangi.digital.core.domain.usecase.WisataUseCase
import com.bwx.tamansari.ui.homestay.choose_room.ChooseRoomViewModel
import com.bwx.tamansari.ui.homestay.list.HomestayViewModel
import com.bwx.tamansari.ui.wisata.choose_ticket.ChooseTicketWisataViewModel
import com.bwx.tamansari.ui.wisata.detail.rating.RatingWisataViewModel
import com.bwx.tamansari.ui.wisata.list.ListWisataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<WisataUseCase> { WisataInteractor(get()) }
    factory<HomestayUseCase> { HomestayInteractor(get()) }
}

val viewModelModule = module {
    viewModel { ListWisataViewModel(get()) }
    viewModel { ChooseTicketWisataViewModel() }
    viewModel { RatingWisataViewModel(get()) }
    viewModel { HomestayViewModel(get()) }
    viewModel { ChooseRoomViewModel(get()) }
}