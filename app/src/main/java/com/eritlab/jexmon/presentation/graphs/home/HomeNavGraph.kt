package com.eritlab.jexmon.presentation.graphs.home


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eritlab.jexmon.presentation.graphs.root.Graph
import com.eritlab.jexmon.presentation.screens.conversation_screen.component.ConversationScreen
import com.eritlab.jexmon.presentation.screens.dashboard_screen.component.DashboardScreen
import com.eritlab.jexmon.presentation.screens.favourite_screen.component.FavouriteScreen
import com.eritlab.jexmon.presentation.screens.profile_screen.component.ProfileScreen

@Composable
fun HomeNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME,
        startDestination = ShopHomeScreen.DashboardScreen.route
    ) {
        composable(ShopHomeScreen.DashboardScreen.route) {
            DashboardScreen()
        }
        composable(ShopHomeScreen.FavouriteScreen.route) {
            FavouriteScreen()
        }
        composable(ShopHomeScreen.ConversationScreen.route) {
            ConversationScreen()
        }
        composable(ShopHomeScreen.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}