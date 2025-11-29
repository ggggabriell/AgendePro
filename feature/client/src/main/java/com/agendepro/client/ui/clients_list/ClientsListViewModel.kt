package com.agendepro.client.ui.clients_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agendepro.client.ui.clients_list.model.ClientsListAction
import com.agendepro.client.ui.clients_list.model.ClientsListUiState
import com.agendepro.common.ui.STOP_TIMEOUT_MILLIS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ClientsListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ClientsListUiState())
    val uiState: StateFlow<ClientsListUiState> = _uiState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
        _uiState.value
    )

    fun onAction(action: ClientsListAction) {
        when (action) {
            else -> {}
        }
    }
}