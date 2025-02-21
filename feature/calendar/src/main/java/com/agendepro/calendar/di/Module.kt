package com.agendepro.calendar.di

import com.agendepro.calendar.domain.usecase.GenerateCalendarUseCase
import com.agendepro.calendar.ui.CalendarViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val calendarModule = module {

    single { GenerateCalendarUseCase() }

    viewModel { CalendarViewModel(get()) }
}