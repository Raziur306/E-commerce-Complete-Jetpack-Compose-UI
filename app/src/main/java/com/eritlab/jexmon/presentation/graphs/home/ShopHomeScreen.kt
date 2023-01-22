package com.eritlab.jexmon.presentation.graphs.home

import com.eritlab.jexmon.presentation.graphs.auth_graph.AuthScreen

sealed class ShopHomeScreen(val route: String) {
    object HomeScreen : ShopHomeScreen("home_screen")
    object DashboardScreen : ShopHomeScreen("dashboard_screen")
    object CartScreen : ShopHomeScreen("cart_screen")
    object ConversationScreen : ShopHomeScreen("conversation_screen")
    object ProfileScreen : ShopHomeScreen("profile_screen")
    object FavouriteScreen : ShopHomeScreen("favourite_screen")
    object ProductScreen : ShopHomeScreen("product_screen")
    object OrderPlacedScreen : ShopHomeScreen("order_placed")
    object NotificationScreen : ShopHomeScreen("notification_screen")
}
