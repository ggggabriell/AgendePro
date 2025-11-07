package com.agendepro.calendar.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.agendepro.calendar.ui.components.CalendarContent
import com.agendepro.calendar.ui.components.ErrorContent
import com.agendepro.calendar.ui.model.CalendarAction
import com.agendepro.calendar.ui.model.CalendarUiState
import com.agendepro.design_system.ui.MaterialThemeExtensions.spacing
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
    LaunchedEffect(Unit) { onAction(CalendarAction.LoadCalendar) }

    when (state) {
        is CalendarUiState.Success -> {
            CalendarContent(
                state = state,
                onAction = onAction
            )
        }

        is CalendarUiState.Loading, CalendarUiState.Idle -> {
            LoadingIndicator(modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.extraExtraLarge))
        }

        is CalendarUiState.Error -> {
            ErrorContent(
                message = state.message,
                onRetry = { onAction(CalendarAction.Retry) }
            )
        }
    }
}