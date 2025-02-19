package com.agendepro.agendepro.di

import com.agendepro.agendepro.ui.main.MainViewModel
import com.agendepro.home.di.homeModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getModules() = listOf(
    appModule,
    homeModule
)

val appModule = module {
    viewModel { MainViewModel() }
}
