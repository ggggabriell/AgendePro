package com.agendepro.client.ui.clients_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.agendepro.client.R
import com.agendepro.design_system.ui.AgendeProTheme
import com.agendepro.ui.ui.top_bar.DefaultTopBar

@Composable
fun ClientsListScreenRoot() {
    ClientsListScreen()
}

@Composable
fun ClientsListScreen() {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.client_list_screen_title),
                onBackClick = {}
            )
        },
        content = { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                Text(text =  stringResource(R.string.client_list_screen_title))
            }
        }
    )
}
@Composable
@Preview
private fun ClientsListScreenPreview() {
    AgendeProTheme {
        ClientsListScreen()
    }
}