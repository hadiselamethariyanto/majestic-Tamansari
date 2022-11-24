package com.bwx.tamansari

import android.app.Application
import banyuwangi.digital.core.di.firebaseModule
import banyuwangi.digital.core.di.networkModule
import banyuwangi.digital.core.di.repositoryModule
import com.bwx.tamansari.di.useCaseModule
import com.bwx.tamansari.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TamansariApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@TamansariApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    firebaseModule
                )
            )
        }
    }
}