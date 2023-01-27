package com.eritlab.jexmon.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.eritlab.jexmon.presentation.graphs.root_graph.RootNavigationGraph
import com.eritlab.jexmon.presentation.ui.theme.JexmonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JexmonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowScreen(LocalContext.current)
                }
            }
        }
    }
}

@Composable
private fun ShowScreen(context: Context) {
    val navHostController = rememberNavController()



    RootNavigationGraph(navHostController = navHostController, context = context)
}

