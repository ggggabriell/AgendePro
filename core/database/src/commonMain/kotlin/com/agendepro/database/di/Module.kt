package com.agendepro.database.di

import com.agendepro.database.AgendeProDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { AgendeProDatabase(get()) }
    single { get<AgendeProDatabase>().clientQueries }
}