package com.eritlab.jexmon.presentation.dashboard_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eritlab.jexmon.presentation.screens.home_screen.BottomNavItem
import com.eritlab.jexmon.presentation.ui.theme.PrimaryColor
import com.eritlab.jexmon.presentation.ui.theme.PrimaryLightColor

@Composable
fun NavigationBar(navController: NavController) {
    val navItemList = listOf(
        BottomNavItem.HomeNav,
        BottomNavItem.FavouriteNav,
        BottomNavItem.ChatNav,
        BottomNavItem.ProfileNav,
    )


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = remember { mutableStateOf(navItemList[0]) }
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            //  .padding(bottom = 10.dp, top = 10.dp)
            .background(color = Color.White)
            .shadow(
                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                elevation = 12.dp,
            )
            .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))


    ) {
        navItemList.forEach { screen ->
            BottomNavigationItem(
                selected = currentScreen.value.route == screen.route,
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null,
                        tint = if (currentScreen.value == screen) MaterialTheme.colors.PrimaryColor else LocalContentColor.current,
                    )
                },
                label = { Text(text = screen.tittle) },
                onClick = {
                    navController.navigate(screen.route)
                    currentScreen.value = screen
                },
                unselectedContentColor = MaterialTheme.colors.PrimaryLightColor,
            )
        }
    }
}