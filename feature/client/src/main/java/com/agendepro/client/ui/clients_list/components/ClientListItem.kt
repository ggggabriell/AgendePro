package com.agendepro.client.ui.clients_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.agendepro.client.domain.model.Client
import com.agendepro.design_system.ui.MaterialThemeExtensions.spacing

@Composable
fun ClientListItem(client: Client, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
            Text(text = client.name, style = MaterialTheme.typography.titleMedium)
            Text(text = client.email, style = MaterialTheme.typography.bodySmall)
        }
    }
}