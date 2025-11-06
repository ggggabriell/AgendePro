package com.agendepro.calendar.domain.usecase

import com.agendepro.calendar.domain.model.CalendarData
import com.agendepro.calendar.domain.model.constant.CalendarConstants.DAYS_IN_WEEK
import java.time.LocalDate

/**
 * Use case to generate the calendar grid.
 */
class GenerateCalendarUseCase {

    companion object {
        const val FIRST_DAY = 1
    }

    operator fun invoke(date: LocalDate = LocalDate.now()): CalendarData {
        val firstDayOfMonth = date.withDayOfMonth(FIRST_DAY)
        val daysInMonth = date.lengthOfMonth()
        val startingDay = firstDayOfMonth.dayOfWeek.ordinal

        val daysGrid = generateCalendarGrid(firstDayOfMonth, daysInMonth, startingDay)

        return CalendarData(
            currentDate = date,
            days = daysGrid
        )
    }

    /**
     * Function to generate the complete grid (including empty cells).
     *
     * @param firstDayOfMonth
     * @param daysInMonth
     * @param startingDay
     */
    private fun generateCalendarGrid(
        firstDayOfMonth: LocalDate,
        daysInMonth: Int,
        startingDay: Int
    ): List<LocalDate?> {
        val dayGrid = List(startingDay) { null } + (0 until daysInMonth).map {
            firstDayOfMonth.plusDays(it.toLong())
        }

        val remainingCells = (DAYS_IN_WEEK - (dayGrid.size % DAYS_IN_WEEK)) % DAYS_IN_WEEK
        return dayGrid + List(remainingCells) { null }
    }
}
