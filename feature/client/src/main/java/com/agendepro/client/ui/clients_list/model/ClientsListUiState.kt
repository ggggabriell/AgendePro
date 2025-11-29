package com.agendepro.client.ui.clients_list.model

import com.agendepro.client.domain.model.Client

data class ClientsListUiState(
    val isLoading: Boolean = false,
    val clients: List<Client> = emptyList(),
    val errorMessage: String? = null
) {
    val showClients: Boolean = !isLoading && errorMessage.isNullOrEmpty() && clients.isNotEmpty()
}
