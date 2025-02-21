package com.agendepro.home.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel: ViewModel() {
    private val _state = MutableStateFlow(UiState("Home Composable"))
    val state: StateFlow<UiState> = _state
}

data class UiState(val someValue: String)
