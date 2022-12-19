package com.bwx.tamansari.di

import banyuwangi.digital.core.domain.usecase.*
import banyuwangi.digital.core.domain.usecase.banner.BannerInteractor
import banyuwangi.digital.core.domain.usecase.banner.BannerUseCase
import banyuwangi.digital.core.domain.usecase.homestay.HomestayInteractor
import banyuwangi.digital.core.domain.usecase.homestay.HomestayUseCase
import banyuwangi.digital.core.domain.usecase.maps.MapsInteractor
import banyuwangi.digital.core.domain.usecase.maps.MapsUseCase
import banyuwangi.digital.core.domain.usecase.payment.PaymentInteractor
import banyuwangi.digital.core.domain.usecase.payment.PaymentUseCase
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodInteractor
import banyuwangi.digital.core.domain.usecase.payment_method.PaymentMethodUseCase
import banyuwangi.digital.core.domain.usecase.restaurant.RestaurantInteractor
import banyuwangi.digital.core.domain.usecase.restaurant.RestaurantUseCase
import banyuwangi.digital.core.domain.usecase.search.SearchInteractor
import banyuwangi.digital.core.domain.usecase.search.SearchUseCase
import banyuwangi.digital.core.domain.usecase.tpsr.TpsrInteractor
import banyuwangi.digital.core.domain.usecase.tpsr.TpsrUseCase
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
import banyuwangi.digital.core.domain.usecase.travel_package.TravelPackageInteractor
import banyuwangi.digital.core.domain.usecase.travel_package.TravelPackageUseCase
import banyuwangi.digital.core.domain.usecase.wisata.WisataInteractor
import banyuwangi.digital.core.domain.usecase.wisata.WisataUseCase
import com.bwx.tamansari.ui.akun.AccountViewModel
import com.bwx.tamansari.ui.berita.list.NewsViewModel
import com.bwx.tamansari.ui.home.HomeViewModel
import com.bwx.tamansari.ui.homestay.choose_room.ChooseRoomViewModel
import com.bwx.tamansari.ui.homestay.detail.DetailHomestayViewModel
import com.bwx.tamansari.ui.homestay.list.HomestayViewModel
import com.bwx.tamansari.ui.homestay.review_transaction.ReviewTransactionHomestayViewModel
import com.bwx.tamansari.ui.login.LoginViewModel
import com.bwx.tamansari.ui.paket.detail.DetailTravelPackageViewModel
import com.bwx.tamansari.ui.paket.list.PaketViewModel
import com.bwx.tamansari.ui.paket.review.ReviewTransactionTravelPackageViewModel
import com.bwx.tamansari.ui.payment.choose_payment_method.ChoosePaymentMethodViewModel
import com.bwx.tamansari.ui.peta.MapsViewModel
import com.bwx.tamansari.ui.restaurant.detail.DetailRestaurantViewModel
import com.bwx.tamansari.ui.restaurant.list.RestaurantViewModel
import com.bwx.tamansari.ui.restaurant.review.ReviewTransactionRestaurantViewModel
import com.bwx.tamansari.ui.search.SearchViewModel
import com.bwx.tamansari.ui.ticket.wisata.MyTicketWisataViewModel
import com.bwx.tamansari.ui.ticket.homestay.MyTicketHomestayViewModel
import com.bwx.tamansari.ui.ticket.restaurant.MyTicketRestaurantViewModel
import com.bwx.tamansari.ui.ticket.travel_package.MyTicketTravelPackageViewModel
import com.bwx.tamansari.ui.tpsr.TpsrViewModel
import com.bwx.tamansari.ui.transaction.TransactionsViewModel
import com.bwx.tamansari.ui.wisata.choose_ticket.ChooseTicketWisataViewModel
import com.bwx.tamansari.ui.wisata.detail.DetailWisataViewModel
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
    factory<MapsUseCase> { MapsInteractor(get()) }
    factory<TpsrUseCase> { TpsrInteractor(get()) }
    factory<SearchUseCase> { SearchInteractor(get()) }
    factory<BannerUseCase> { BannerInteractor(get()) }
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
    viewModel { AccountViewModel(get(), get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { ReviewWisataViewModel(get(), get()) }
    viewModel { ReviewTransactionHomestayViewModel(get(), get()) }
    viewModel { ReviewTransactionTravelPackageViewModel(get(), get()) }
    viewModel { ChoosePaymentMethodViewModel(get(), get(), get(), get(), get(), get()) }
    viewModel { TransactionsViewModel(get(), get()) }
    viewModel { MyTicketWisataViewModel(get()) }
    viewModel { MyTicketHomestayViewModel(get()) }
    viewModel { MyTicketTravelPackageViewModel(get()) }
    viewModel { DetailRestaurantViewModel(get()) }
    viewModel { ReviewTransactionRestaurantViewModel(get(), get(), get()) }
    viewModel { MyTicketRestaurantViewModel(get()) }
    viewModel { MapsViewModel(get()) }
    viewModel { DetailWisataViewModel(get()) }
    viewModel { DetailHomestayViewModel(get()) }
    viewModel { TpsrViewModel(get(), get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailTravelPackageViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}