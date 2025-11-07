package com.agendepro.calendar.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.style.TextAlign
import com.agendepro.calendar.R
import com.agendepro.calendar.domain.model.constant.CalendarConstants.DAYS_IN_WEEK
import com.agendepro.calendar.ui.model.CalendarAction
import com.agendepro.calendar.ui.model.CalendarUiState
import com.agendepro.design_system.ui.MaterialThemeExtensions.spacing
import java.time.LocalDate

@Composable
fun CalendarContent(
    state: CalendarUiState.Success,
    onAction: (CalendarAction) -> Unit
) {
    var isExpanded by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.screenPadding)
    ) {
        CalendarHeader(
            currentDate = state.currentDate,
            isExpanded = isExpanded,
            onToggle = { isExpanded = !isExpanded }
        )

        AnimatedVisibility(visible = isExpanded) {
            CalendarGrid(
                days = state.days,
                currentDate = state.currentDate,
                onDateClick = { date ->
                    onAction(CalendarAction.DateSelected(date))
                }
            )
        }
    }
}

@Composable
private fun CalendarGrid(
    days: List<LocalDate?>,
    currentDate: LocalDate,
    onDateClick: (LocalDate) -> Unit
) {
    val dayNames = stringArrayResource(R.array.days_of_week_short).toList()

    Column {
        // Weekday Header
        WeekdayHeader(dayNames = dayNames)

        // Calendar Days Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(DAYS_IN_WEEK),
            contentPadding = PaddingValues(MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall)
        ) {
            items(days.size) { index ->
                val date = days[index]

                if (date != null) {
                    DayCell(
                        date = date,
                        isSelected = date == currentDate,
                        onClick = { onDateClick(date) }
                    )
                } else {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(MaterialTheme.spacing.extraExtraLarge)
                    )
                }
            }
        }
    }
}

@Composable
private fun WeekdayHeader(dayNames: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        dayNames.forEach { dayName ->
            Text(
                text = dayName,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}