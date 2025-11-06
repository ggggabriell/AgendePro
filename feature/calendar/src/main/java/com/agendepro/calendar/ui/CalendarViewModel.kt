package com.agendepro.calendar.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agendepro.calendar.domain.usecase.GenerateCalendarUseCase
import com.agendepro.calendar.ui.model.CalendarAction
import com.agendepro.calendar.ui.model.CalendarUiState
import com.agendepro.common.ui.STOP_TIMEOUT_MILLIS
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CalendarViewModel(
    private val generateCalendarUseCase: GenerateCalendarUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<CalendarUiState>(CalendarUiState.Idle)
    val uiState = _uiState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
        _uiState.value
    )

    fun onAction(action: CalendarAction) {
        when (action) {
            CalendarAction.LoadCalendar -> loadCalendar()
            CalendarAction.Retry -> loadCalendar()
            is CalendarAction.DateSelected -> {}
            is CalendarAction.LoadMonth -> {}
            CalendarAction.NextMonth -> {}
            CalendarAction.PreviousMonth -> {}
        }
    }

    private fun loadCalendar() {
        viewModelScope.launch(errorHandler) {
            _uiState.value = CalendarUiState.Loading
            delay(1000) // Only testing.

            val calendar = generateCalendarUseCase()
            _uiState.value = CalendarUiState.Success(calendar.currentDate, calendar.days)
        }
    }

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.value = CalendarUiState.Error(throwable.message ?: "Unknown error")
    }
}

