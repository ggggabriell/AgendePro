package com.agendepro.calendar.data.model

import java.time.LocalDate

data class CalendarData(
    val currentDate: LocalDate,
    val days: List<LocalDate?>
)