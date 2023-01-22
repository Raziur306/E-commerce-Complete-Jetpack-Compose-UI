package com.eritlab.jexmon.presentation.graphs.root

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eritlab.jexmon.presentation.graphs.authNavGraph
import com.eritlab.jexmon.presentation.screens.home_screen.component.HomeScreen


@Composable
fun RootNavigationGraph(navHostController: NavHostController, context: Context) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION,
    ) {
        authNavGraph(navHostController, context)
        composable(route = Graph.HOME) {
            HomeScreen()
        }


    }
}