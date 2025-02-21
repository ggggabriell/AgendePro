package com.agendepro.calendar.domain.usecase

import com.agendepro.calendar.data.model.CalendarData
import java.time.LocalDate


class GenerateCalendarUseCase {

    operator fun invoke(date: LocalDate = LocalDate.now()): CalendarData {

        // Generate the full calendar for the given month and year
        val firstDayOfMonth = date.withDayOfMonth(1)
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

        val remainingCells = (7 - (dayGrid.size % 7)) % 7
        return dayGrid + List(remainingCells) { null }
    }
}