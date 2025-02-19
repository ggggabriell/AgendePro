package com.agendepro.agendepro.di

import com.agendepro.agendepro.ui.main.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getModules() = listOf(
    appModule
)

val appModule = module {
    viewModel { MainViewModel() }
}
