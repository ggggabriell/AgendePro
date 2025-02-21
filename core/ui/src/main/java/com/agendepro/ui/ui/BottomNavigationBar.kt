package com.agendepro.ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.agendepro.ui.ui.theme.Gray80
import java.util.Locale

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    Column {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Gray80
        )

        NavigationBar {
            val items = listOf("home")
            items.forEach { screen ->
                when (screen) {
                    "home" -> {
                        NavigationBarItem(
                            label = { Text(screen.capitalize(Locale.ROOT)) },
                            selected = false,
                            onClick = { navController.navigate(screen) },
                            icon = { Icon(Icons.Default.Home, contentDescription = screen) },
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surface)
                        )
                    }
                }
            }
        }
    }
}