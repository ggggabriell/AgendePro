package com.agendepro.calendar.ui.model

import java.time.LocalDate

sealed interface CalendarUiState {
    object Idle : CalendarUiState
    object Loading : CalendarUiState
    data class Success(
        val currentDate: LocalDate,
        val days: List<LocalDate?>
    ) : CalendarUiState
    data class Error(val message: String) : CalendarUiState
}
