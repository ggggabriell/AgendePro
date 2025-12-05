package com.agendepro.client.ui.clients_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.agendepro.client.R
import com.agendepro.client.domain.model.Client
import com.agendepro.client.ui.clients_list.components.ClientListItem
import com.agendepro.client.ui.clients_list.model.ClientsListAction
import com.agendepro.client.ui.clients_list.model.ClientsListUiState
import com.agendepro.design_system.ui.AgendeProTheme
import com.agendepro.design_system.ui.MaterialThemeExtensions.spacing
import com.agendepro.ui.ui.top_bar.DefaultTopBar
import org.koin.androidx.compose.koinViewModel
import com.agendepro.ui.R as UiR

@Composable
fun ClientsListScreenRoot(
    viewModel: ClientsListViewModel = koinViewModel(),
) {
    val state by viewModel.uiState.collectAsState()

    ClientsListScreen(
        state = state,
        onAction = { action ->
            when (action) {
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun ClientsListScreen(
    state: ClientsListUiState,
    onAction: (ClientsListAction) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.client_list_screen_title),
                onBackClick = { }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "Add Client")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MaterialTheme.spacing.medium,
                        vertical = MaterialTheme.spacing.small
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    label = { Text(stringResource(R.string.client_list_screen_search_label)) },
                    singleLine = true,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.padding(start = MaterialTheme.spacing.small)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.List,
                        contentDescription = stringResource(UiR.string.content_desc_list)
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.medium
                ),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall)
            ) {
                items(state.clients) { client ->
                    ClientListItem(client = client, onClick = { })
                }
            }
        }
    }
}


@Composable
@Preview
private fun ClientsListScreenPreview() {
    AgendeProTheme {
        ClientsListScreen(
            state = ClientsListUiState(
                clients = listOf(
                    Client.buildEmpty().copy(name = "Joaoo", email = "john.jay@example.com"),
                    Client.buildEmpty().copy(
                        name = "Maria",
                        email = "william.henry.moody@my-own-personal-domain.com"
                    ),
                    Client.buildEmpty()
                        .copy(name = "João", email = "john.quincy.adams@examplepetstore.com")
                )
            ),
            onAction = {}
        )
    }
}