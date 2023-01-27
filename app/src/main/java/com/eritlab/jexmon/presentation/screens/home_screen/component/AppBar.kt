package com.eritlab.jexmon.presentation.dashboard_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.eritlab.jexmon.R
import com.eritlab.jexmon.presentation.graphs.home_graph.ShopHomeScreen
import com.eritlab.jexmon.presentation.ui.theme.PrimaryColor
import com.eritlab.jexmon.presentation.ui.theme.PrimaryLightColor

@Composable
fun AppBar(
    navController: NavController,
    isVisible: Boolean,
    searchCharSequence: (String) -> Unit,
    onNotificationIconClick: () -> Unit,
    onCartIconClick: () -> Unit
) {
    var typedText by remember {
        mutableStateOf(TextFieldValue())
    }
    if (isVisible) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            TextField(
                value = typedText,
                onValueChange = { newText ->
                    typedText = newText
                    searchCharSequence(newText.text)
                },
                singleLine = true,
                placeholder = { Text(text = "Search product") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Product Search Icon"
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.PrimaryColor
                ),


                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.PrimaryLightColor,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .weight(1f),

                )

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.PrimaryLightColor)
                    .clickable {
                        onCartIconClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart_icon),
                    contentDescription = "Cart Icon"
                )
            }
            ConstraintLayout() {
                val (notification, notificationCounter) = createRefs()

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.PrimaryLightColor)
                        .constrainAs(notification) {}
                        .clickable {
                            onNotificationIconClick()
                        },

                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bell),
                        contentDescription = "Notification Icon"
                    )

                }
                //notification count
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = Color.Red, shape = CircleShape)
                        .padding(3.dp)
                        .constrainAs(notificationCounter) {
                            top.linkTo(notification.top)
                            end.linkTo(notification.end)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "3", fontSize = 11.sp, color = Color.White)
                }

            }


        }
    }


}