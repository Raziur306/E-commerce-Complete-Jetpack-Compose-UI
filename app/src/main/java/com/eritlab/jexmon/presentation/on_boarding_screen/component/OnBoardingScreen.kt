package com.eritlab.jexmon.presentation.on_boarding_screen.component

import android.content.Context
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eritlab.jexmon.presentation.ui.theme.RedOrange
import com.eritlab.jexmon.R
import com.eritlab.jexmon.presentation.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun SplashScreen(navController: NavController) {
    val splashImageList = listOf(
        R.drawable.splash_1,
        R.drawable.splash_2,
        R.drawable.splash_3,
    )
    val currentPosition = remember { mutableStateOf(0) }
    val animate = remember { mutableStateOf(true) }
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        AnimatedContent(
            targetState = animate.value,
            modifier = Modifier
                .fillMaxWidth(),
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { value ->
                        value
                    }
                ) with slideOutHorizontally(
                    targetOffsetX = { value ->
                        -value
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "JEXMON",
                        fontSize = 50.sp,
                        color = MaterialTheme.colors.RedOrange,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    when (currentPosition.value) {
                        0 -> {
                            Text(
                                text = buildAnnotatedString {
                                    append(text = "Welcome to ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.DarkGray
                                        )
                                    ) {
                                        append("Jexmon.")
                                    }
                                    append(" Let's Shop!")
                                },
                                color = Color.LightGray,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        1 -> {
                            Text(
                                text = "We help people connect with store\naround Bangladesh",
                                color = Color.LightGray,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        else -> {
                            Text(
                                text = "We show easy way to shop.\nJust stay at home with us",
                                color = Color.LightGray,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = painterResource(id = splashImageList[currentPosition.value]),
                        contentDescription = "Splash Image",
                        modifier = Modifier.padding(40.dp)
                    )
                }
            }
        )


        DotIndicator(splashImageList.size, currentPosition.value)
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(20.dp)),
            onClick = {
                if (currentPosition.value < 2) {
                    currentPosition.value++
                    animate.value = !animate.value

                } else {
                    navController.navigate(Screen.SignInScreen.route)
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.RedOrange,
                contentColor = Color.White
            ),
        ) {
            Text(text = "Continue", fontSize = 16.sp)
        }
    }
}