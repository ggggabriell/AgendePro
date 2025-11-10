package com.agendepro.database

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidDatabaseModule = module {
    single { DatabaseDriverFactory(androidContext()).createDriver() }
}