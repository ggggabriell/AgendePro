package com.agendepro.calendar.ui.model

import java.time.LocalDate
import java.time.YearMonth

sealed interface CalendarAction {
    object LoadCalendar : CalendarAction
    data class DateSelected(val date: LocalDate) : CalendarAction
    object Retry : CalendarAction
    object NextMonth : CalendarAction
    object PreviousMonth : CalendarAction
    data class LoadMonth(val yearMonth: YearMonth) : CalendarAction
}