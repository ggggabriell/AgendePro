package com.agendepro.navigation.ui.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
}
