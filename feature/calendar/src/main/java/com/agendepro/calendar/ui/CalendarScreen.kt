package com.agendepro.calendar.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun CalendarScreen(
    onDateSelected: (LocalDate) -> Unit = {}
) {
    val viewModel: CalendarViewModel = koinViewModel()

    val uiState by viewModel.uiState.observeAsState()

    uiState?.let { state ->
        Column(modifier = Modifier.fillMaxSize()) {
            // Month Header
            Text(
                text = "${state.currentDate.month.name} ${state.currentDate.year}",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // Weekday Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Calendar Grid
            LazyVerticalGrid(columns = GridCells.Fixed(7)) {
                items(state.days.size) { index ->
                    val date = state.days[index]

                    if (date != null) {
                        DayCell(
                            date = date,
                            isSelected = date == state.currentDate,
                            onClick = { onDateSelected(date) }
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
    } ?: run {
        // Show a loading state or empty state if uiState is null
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    LaunchedEffect(Unit) { viewModel.loadCalendar() }
}