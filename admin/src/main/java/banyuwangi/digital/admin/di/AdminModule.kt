package banyuwangi.digital.admin.di

import banyuwangi.digital.admin.ui.screens.attraction.detail.AttractionDetailViewModel
import banyuwangi.digital.admin.ui.screens.attraction.list.AttractionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val adminModule = module {
    viewModel { AttractionViewModel(get()) }
    viewModel { AttractionDetailViewModel(get(),get()) }
}