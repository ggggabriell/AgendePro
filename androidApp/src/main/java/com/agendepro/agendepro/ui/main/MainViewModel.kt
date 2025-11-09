package com.agendepro.agendepro.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val _state = MutableStateFlow(UiState("World"))
    val state: StateFlow<UiState> = _state
}

data class UiState(val someValue: String)
