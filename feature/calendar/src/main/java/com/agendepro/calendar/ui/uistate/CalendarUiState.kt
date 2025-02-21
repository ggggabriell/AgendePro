package com.agendepro.calendar.ui.uistate

import java.time.LocalDate

data class CalendarUiState(
    val currentDate: LocalDate,
    val days: List<LocalDate?>
)