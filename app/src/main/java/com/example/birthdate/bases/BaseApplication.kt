package com.example.birthdate.bases

import android.app.Application
import com.example.birthdate.di.networkModules
import com.example.birthdate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(viewModelModule, networkModules)
        }
    }

}