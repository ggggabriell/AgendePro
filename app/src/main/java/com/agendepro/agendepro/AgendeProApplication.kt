package com.agendepro.agendepro

import android.app.Application
import com.agendepro.agendepro.di.getModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AgendeProApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AgendeProApplication)
            modules(getModules())
        }
    }
}