package com.agendepro.calendar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agendepro.calendar.domain.usecase.GenerateCalendarUseCase
import com.agendepro.calendar.ui.uistate.CalendarUiState
import java.time.LocalDate

class CalendarViewModel(
    private val generateCalendarUseCase: GenerateCalendarUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<CalendarUiState>()
    val uiState: LiveData<CalendarUiState> = _uiState

    fun loadCalendar(date: LocalDate = LocalDate.now()) {
        val calendar = generateCalendarUseCase(date)
        _uiState.value = CalendarUiState(calendar.currentDate, calendar.days)
    }
}

