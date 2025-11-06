package com.agendepro.calendar.domain.model

import java.time.LocalDate

data class CalendarData(
    val currentDate: LocalDate,
    val days: List<LocalDate?>
)