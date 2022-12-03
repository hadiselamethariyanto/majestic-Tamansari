package com.bwx.tamansari.di

import banyuwangi.digital.core.domain.usecase.*
import banyuwangi.digital.core.domain.usecase.payment.PaymentInteractor
import banyuwangi.digital.core.domain.usecase.payment.PaymentUseCase
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodInteractor
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodUseCase
import banyuwangi.digital.core.domain.usecase.transaction_homestay.TransactionHomestayInteractor
import banyuwangi.digital.core.domain.usecase.transaction_homestay.TransactionHomestayUseCase
import banyuwangi.digital.core.domain.usecase.transaction_restaurant.TransactionRestaurantInteractor
import banyuwangi.digital.core.domain.usecase.transaction_restaurant.TransactionRestaurantUseCase
import banyuwangi.digital.core.domain.usecase.transaction_travel_package.TransactionTravelPackageInteractor
import banyuwangi.digital.core.domain.usecase.transaction_travel_package.TransactionTravelPackageUseCase
import banyuwangi.digital.core.domain.usecase.transaction_wisata.TransactionWisataInteractor
import banyuwangi.digital.core.domain.usecase.transaction_wisata.TransactionWisataUsecase
import banyuwangi.digital.core.domain.usecase.transactions.TransactionsInteractor
import banyuwangi.digital.core.domain.usecase.transactions.TransactionsUseCase
import com.bwx.tamansari.ui.akun.AccountViewModel
import com.bwx.tamansari.ui.berita.list.NewsViewModel
import com.bwx.tamansari.ui.homestay.choose_room.ChooseRoomViewModel
import com.bwx.tamansari.ui.homestay.list.HomestayViewModel
import com.bwx.tamansari.ui.homestay.review_transaction.ReviewTransactionHomestayViewModel
import com.bwx.tamansari.ui.login.LoginViewModel
import com.bwx.tamansari.ui.paket.list.PaketViewModel
import com.bwx.tamansari.ui.paket.review.ReviewTransactionTravelPackageViewModel
import com.bwx.tamansari.ui.payment.choose_payment_method.ChoosePaymentMethodViewModel
import com.bwx.tamansari.ui.restaurant.detail.DetailRestaurantViewModel
import com.bwx.tamansari.ui.restaurant.list.RestaurantViewModel
import com.bwx.tamansari.ui.restaurant.review.ReviewTransactionRestaurantViewModel
import com.bwx.tamansari.ui.ticket.wisata.MyTicketWisataViewModel
import com.bwx.tamansari.ui.ticket.homestay.MyTicketHomestayViewModel
import com.bwx.tamansari.ui.ticket.travel_package.MyTicketTravelPackageViewModel
import com.bwx.tamansari.ui.transaction.TransactionsViewModel
import com.bwx.tamansari.ui.wisata.choose_ticket.ChooseTicketWisataViewModel
import com.bwx.tamansari.ui.wisata.detail.rating.RatingWisataViewModel
import com.bwx.tamansari.ui.wisata.list.ListWisataViewModel
import com.bwx.tamansari.ui.wisata.review.ReviewWisataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<WisataUseCase> { WisataInteractor(get()) }
    factory<HomestayUseCase> { HomestayInteractor(get()) }
    factory<TravelPackageUseCase> { TravelPackageInteractor(get()) }
    factory<RestaurantUseCase> { RestaurantInteractor(get()) }
    factory<NewsUseCase> { NewsInteractor(get()) }
    factory<AuthUseCase> { AuthInteractor(get()) }
    factory<TransactionWisataUsecase> { TransactionWisataInteractor(get()) }
    factory<PaymentMethodUseCase> { PaymentMethodInteractor(get()) }
    factory<TransactionsUseCase> { TransactionsInteractor(get()) }
    factory<PaymentUseCase> { PaymentInteractor(get()) }
    factory<TransactionHomestayUseCase> { TransactionHomestayInteractor(get()) }
    factory<TransactionTravelPackageUseCase> { TransactionTravelPackageInteractor(get()) }
    factory<TransactionRestaurantUseCase> { TransactionRestaurantInteractor(get()) }
}

val viewModelModule = module {
    viewModel { ListWisataViewModel(get()) }
    viewModel { ChooseTicketWisataViewModel() }
    viewModel { RatingWisataViewModel(get()) }
    viewModel { HomestayViewModel(get()) }
    viewModel { ChooseRoomViewModel(get()) }
    viewModel { PaketViewModel(get()) }
    viewModel { RestaurantViewModel(get()) }
    viewModel { NewsViewModel(get()) }
    viewModel { AccountViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { ReviewWisataViewModel(get(), get()) }
    viewModel { ReviewTransactionHomestayViewModel(get(), get()) }
    viewModel { ReviewTransactionTravelPackageViewModel(get(), get()) }
    viewModel { ChoosePaymentMethodViewModel(get(), get(), get(), get(), get()) }
    viewModel { TransactionsViewModel(get(), get()) }
    viewModel { MyTicketWisataViewModel(get()) }
    viewModel { MyTicketHomestayViewModel(get()) }
    viewModel { MyTicketTravelPackageViewModel(get()) }
    viewModel { DetailRestaurantViewModel() }
    viewModel { ReviewTransactionRestaurantViewModel(get(), get(),get()) }
}