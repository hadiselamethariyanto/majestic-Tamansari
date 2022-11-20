package banyuwangi.digital.core.di

import banyuwangi.digital.core.BuildConfig
import banyuwangi.digital.core.data.homestay.repository.HomestayRepositoryImpl
import banyuwangi.digital.core.data.homestay.repository.source.remote.HomestayRemoteDataSource
import banyuwangi.digital.core.data.homestay.repository.source.remote.network.HomestayService
import banyuwangi.digital.core.data.wisata.repository.WisataRepositoryImpl
import banyuwangi.digital.core.data.wisata.repository.source.remote.WisataRemoteDataSource
import banyuwangi.digital.core.data.wisata.repository.source.remote.network.WisataService
import banyuwangi.digital.core.domain.repository.HomestayRepository
import banyuwangi.digital.core.domain.repository.WisataRepository
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
}

val repositoryModule = module {
    single { WisataRemoteDataSource(get()) }
    single { HomestayRemoteDataSource(get()) }

    single<WisataRepository> { WisataRepositoryImpl(get()) }
    single<HomestayRepository> { HomestayRepositoryImpl(get()) }
}