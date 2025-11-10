package com.agendepro.database

import org.koin.dsl.module

val iosDatabaseModule = module {
    single { DatabaseDriverFactory().createDriver() }
}