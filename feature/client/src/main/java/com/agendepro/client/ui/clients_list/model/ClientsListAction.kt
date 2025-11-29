package com.agendepro.client.ui.clients_list.model

sealed interface ClientsListAction {
    data object OnBackClick : ClientsListAction
    data object OnAddClientClick : ClientsListAction
    data object OnSearchClick : ClientsListAction
    data class OnClientClick(val clientId: Long) : ClientsListAction
}