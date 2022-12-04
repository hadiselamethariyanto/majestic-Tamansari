package banyuwangi.digital.core.di

import banyuwangi.digital.core.BuildConfig
import banyuwangi.digital.core.data.auth.repository.AuthRepositoryImpl
import banyuwangi.digital.core.data.berita.repository.NewsRepositoryImpl
import banyuwangi.digital.core.data.berita.repository.source.remote.NewsRemoteDataSource
import banyuwangi.digital.core.data.berita.repository.source.remote.nework.NewsService
import banyuwangi.digital.core.data.homestay.repository.HomestayRepositoryImpl
import banyuwangi.digital.core.data.homestay.repository.source.remote.HomestayRemoteDataSource
import banyuwangi.digital.core.data.homestay.repository.source.remote.network.HomestayService
import banyuwangi.digital.core.data.payment.repository.PaymentRepositoryImpl
import banyuwangi.digital.core.data.payment.repository.source.remote.PaymentRemoteDataSource
import banyuwangi.digital.core.data.payment.repository.source.remote.network.PaymentService
import banyuwangi.digital.core.data.payment_method.repository.PaymentMethodRepositoryImpl
import banyuwangi.digital.core.data.payment_method.repository.source.remote.PaymentMethodRemoteDataSource
import banyuwangi.digital.core.data.payment_method.repository.source.remote.network.PaymentMethodService
import banyuwangi.digital.core.data.peta.repository.MapsRepositoryImpl
import banyuwangi.digital.core.data.peta.repository.source.remote.MapsRemoteDataSource
import banyuwangi.digital.core.data.peta.repository.source.remote.network.MapsService
import banyuwangi.digital.core.data.restoran.repository.RestaurantRepositoryImpl
import banyuwangi.digital.core.data.restoran.repository.source.remote.RestaurantRemoteDataSource
import banyuwangi.digital.core.data.restoran.repository.source.remote.network.RestaurantService
import banyuwangi.digital.core.data.tpsr.repository.TpsrRepositoryImpl
import banyuwangi.digital.core.data.tpsr.repository.source.remote.TpsrRemoteDataSource
import banyuwangi.digital.core.data.tpsr.repository.source.remote.network.TpsrApiService
import banyuwangi.digital.core.data.transaction_homestay.repository.TransactionHomestayRepositoryImpl
import banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.TransactionHomestayRemoteDataSource
import banyuwangi.digital.core.data.transaction_homestay.repository.source.remote.network.TransactionHomestayService
import banyuwangi.digital.core.data.transaction_restaurant.repository.TransactionRestaurantRepositoryImpl
import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.TransactionRestaurantRemoteDataSource
import banyuwangi.digital.core.data.transaction_restaurant.repository.source.remote.network.TransactionRestaurantService
import banyuwangi.digital.core.data.transaction_travel_package.repository.TransactionTravelPackageRepositoryImpl
import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.TransactionTravelPackageRemoteDataSource
import banyuwangi.digital.core.data.transaction_travel_package.repository.source.remote.network.TransactionTravelPackageService
import banyuwangi.digital.core.data.transaction_wisata.repository.TransactionWisataRepositoryImpl
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.TransactionWisataRemoteDataSource
import banyuwangi.digital.core.data.transaction_wisata.repository.source.remote.network.TransactionWisataService
import banyuwangi.digital.core.data.transactions.repository.TransactionsRepositoryImpl
import banyuwangi.digital.core.data.transactions.repository.source.remote.TransactionsRemoteDataSource
import banyuwangi.digital.core.data.transactions.repository.source.remote.network.TransactionsService
import banyuwangi.digital.core.data.travel_package.repository.TravelPackageRepositoryImpl
import banyuwangi.digital.core.data.travel_package.repository.source.remote.TravelPackageRemoteDataSource
import banyuwangi.digital.core.data.travel_package.repository.source.remote.network.TravelPackageService
import banyuwangi.digital.core.data.wisata.repository.WisataRepositoryImpl
import banyuwangi.digital.core.data.wisata.repository.source.remote.WisataRemoteDataSource
import banyuwangi.digital.core.data.wisata.repository.source.remote.network.WisataService
import banyuwangi.digital.core.domain.repository.*
import com.google.firebase.auth.FirebaseAuth
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(WisataService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(HomestayService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TravelPackageService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(RestaurantService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(NewsService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TransactionWisataService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(PaymentMethodService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TransactionsService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(PaymentService::class.java)
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TransactionHomestayService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TransactionTravelPackageService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TransactionRestaurantService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(MapsService::class.java)
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(TpsrApiService::class.java)
    }
}

val repositoryModule = module {
    single { WisataRemoteDataSource(get()) }
    single { HomestayRemoteDataSource(get()) }
    single { TravelPackageRemoteDataSource(get()) }
    single { RestaurantRemoteDataSource(get()) }
    single { NewsRemoteDataSource(get()) }
    single { TransactionWisataRemoteDataSource(get()) }
    single { PaymentMethodRemoteDataSource(get()) }
    single { TransactionsRemoteDataSource(get()) }
    single { PaymentRemoteDataSource(get()) }
    single { TransactionHomestayRemoteDataSource(get()) }
    single { TransactionTravelPackageRemoteDataSource(get()) }
    single { TransactionRestaurantRemoteDataSource(get()) }
    single { MapsRemoteDataSource(get()) }
    single { TpsrRemoteDataSource(get()) }

    single<WisataRepository> { WisataRepositoryImpl(get()) }
    single<HomestayRepository> { HomestayRepositoryImpl(get()) }
    single<TravelPackageRepository> { TravelPackageRepositoryImpl(get()) }
    single<RestaurantRepository> { RestaurantRepositoryImpl(get()) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<TransactionWisataRepository> { TransactionWisataRepositoryImpl(get()) }
    single<PaymentMethodRepository> { PaymentMethodRepositoryImpl(get()) }
    single<TransactionsRepository> { TransactionsRepositoryImpl(get()) }
    single<PaymentRepository> { PaymentRepositoryImpl(get()) }
    single<TransactionHomestayRepository> { TransactionHomestayRepositoryImpl(get()) }
    single<TransactionTravelPackageRepository> { TransactionTravelPackageRepositoryImpl(get()) }
    single<TransactionRestaurantRepository> { TransactionRestaurantRepositoryImpl(get()) }
    single<MapsRepository> { MapsRepositoryImpl(get()) }
    single<TpsrRepository> { TpsrRepositoryImpl(get()) }
}

val firebaseModule =
    module {
        single {
            FirebaseAuth.getInstance()
        }
    }
