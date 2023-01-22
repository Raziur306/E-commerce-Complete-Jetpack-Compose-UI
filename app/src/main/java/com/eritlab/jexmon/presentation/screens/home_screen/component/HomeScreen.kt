package com.eritlab.jexmon.presentation.screens.home_screen.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eritlab.jexmon.presentation.dashboard_screen.component.AppBar
import com.eritlab.jexmon.presentation.dashboard_screen.component.NavigationBar
import com.eritlab.jexmon.presentation.graphs.home.HomeNavGraph


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(navController = navController, searchCharSequence = {

            })
        },
        bottomBar = {
            NavigationBar(navController = navController)
        }

    ) {
        HomeNavGraph(navHostController = navController)
    }
}