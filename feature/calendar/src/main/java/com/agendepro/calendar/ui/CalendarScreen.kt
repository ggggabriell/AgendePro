package com.agendepro.calendar.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.agendepro.calendar.R
import com.agendepro.calendar.domain.model.constant.CalendarConstants.DAYS_IN_WEEK
import com.agendepro.calendar.ui.model.CalendarAction
import com.agendepro.calendar.ui.model.CalendarUiState
import com.agendepro.ui.ui.loading_indicator.LoadingIndicator
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun CalendarScreenRoot(
    onDateSelected: (LocalDate) -> Unit = {},
    viewModel: CalendarViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    CalendarScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is CalendarAction.DateSelected -> onDateSelected(action.date)
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun CalendarScreen(
    state: CalendarUiState,
    onAction: (CalendarAction) -> Unit
) {
    var isExpanded by remember { mutableStateOf(true) }
    val dayNames = stringArrayResource(R.array.days_of_week_short).toList()

    LaunchedEffect(Unit) { onAction(CalendarAction.LoadCalendar) }

    when (state) {
        is CalendarUiState.Success -> {
            Column(modifier = Modifier.fillMaxSize()) {
                CalendarHeader(
                    currentDate = state.currentDate,
                    isExpanded = isExpanded,
                    onToggle = { isExpanded = !isExpanded }
                )
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        // Weekday Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            dayNames.forEach {
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        // Calendar Grid
                        LazyVerticalGrid(columns = GridCells.Fixed(DAYS_IN_WEEK)) {
                            items(state.days.size) { index ->
                                val date = state.days[index]

                                if (date != null) {
                                    DayCell(
                                        date = date,
                                        isSelected = date == state.currentDate,
                                        onClick = { onAction(CalendarAction.DateSelected(date)) }
                                    )
                                } else {
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(40.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        is CalendarUiState.Loading, CalendarUiState.Idle -> LoadingIndicator()
        is CalendarUiState.Error -> {}
    }
}