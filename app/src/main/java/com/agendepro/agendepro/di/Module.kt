package com.agendepro.agendepro.di

import com.agendepro.agendepro.ui.main.MainViewModel
import com.agendepro.calendar.di.calendarModule
import com.agendepro.home.di.homeModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getModules() = listOf(
    appModule,
    homeModule,
    calendarModule
)

val appModule = module {
    viewModel { MainViewModel() }
}
