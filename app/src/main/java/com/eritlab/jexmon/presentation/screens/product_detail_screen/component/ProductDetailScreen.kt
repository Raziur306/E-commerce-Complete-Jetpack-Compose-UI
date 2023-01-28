package com.eritlab.jexmon.presentation.screens.product_detail_screen.component

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import com.eritlab.jexmon.R
import com.eritlab.jexmon.presentation.common.CustomDefaultBtn
import com.eritlab.jexmon.presentation.screens.product_detail_screen.ProductDetailViewModel
import com.eritlab.jexmon.presentation.ui.theme.PrimaryColor
import com.eritlab.jexmon.presentation.ui.theme.PrimaryLightColor
import com.eritlab.jexmon.presentation.ui.theme.TextColor

@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel = hiltViewModel(),
    popBack: () -> Unit
) {
    val state = viewModel.state.value
    val context = LocalContext.current
    if (state.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (state.productDetail != null) {
        val product = state.productDetail
        var colorSelected by remember { mutableStateOf(product.colors[product.colors.size - 1]) }
        var selectedPicture by remember { mutableStateOf(product.images[0]) }
        var quantity by remember { mutableStateOf(1) }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0x8DB3B0B0)),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        popBack()
                    },
                    modifier = Modifier
                        .background(color = Color.White, shape = CircleShape)
                        .clip(CircleShape)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = null
                    )
                }
                Row(
                    modifier = Modifier
                        .width(70.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(3.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    horizontalArrangement = Arrangement.spacedBy(
                        4.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.rating.toString(),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(id = R.drawable.star_icon),
                        contentDescription = null
                    )
                }


            }
            //image
            Image(
                painter = painterResource(id = selectedPicture),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(product.images.size) {
                    IconButton(
                        onClick = {
                            selectedPicture = product.images[it]
                        },
                        modifier = Modifier
                            .size(50.dp)
                            .border(
                                width = 1.dp,
                                color = if (selectedPicture == product.images[it]) MaterialTheme.colors.PrimaryColor else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(Color.White, shape = RoundedCornerShape(10.dp))
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = painterResource(id = product.images[it]),
                            contentDescription = null,
                        )

                    }
                }

            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                    )
                //   .padding(15.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    ) {
                        Text(
                            text = product.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(25.dp))

                        Text(
                            text = product.description,
                            fontSize = 16.sp,
                            color = MaterialTheme.colors.TextColor
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "See more Details",
                                color = MaterialTheme.colors.PrimaryColor,
                                fontSize = 16.sp,

                                )
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_right),
                                contentDescription = "",
                                tint = MaterialTheme.colors.PrimaryColor
                            )
                        }


                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.heart_icon_2),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.Red),
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    Color(0x75F44336),
                                    shape = RoundedCornerShape(
                                        topStart = 20.dp,
                                        bottomStart = 20.dp
                                    )
                                )
                                .padding(10.dp)
                                .weight(1f)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color(0x8DB3B0B0),
                            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                        )
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        items(product.colors.size) {
                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .border(
                                        width = 1.dp,
                                        color = if (colorSelected == product.colors[it]) MaterialTheme.colors.PrimaryColor else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .background(color = product.colors[it], shape = CircleShape)
                                    .clip(CircleShape)
                                    .clickable {
                                        colorSelected = product.colors[it]
                                    }
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                if (quantity > 1) {
                                    quantity--
                                }
                            },
                            modifier = Modifier
                                .background(color = Color.White, shape = CircleShape)
                                .clip(CircleShape)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.remove),
                                contentDescription = null
                            )
                        }
                        Text(
                            text = quantity.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .width(35.dp)
                                .wrapContentHeight()
                        )
                        IconButton(
                            onClick = {
                                if (quantity < 5) {
                                    quantity++
                                } else {
                                    Toast.makeText(
                                        context,
                                        "You can add maximum 5 item at a time.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            },
                            modifier = Modifier
                                .background(color = Color.White, shape = CircleShape)
                                .clip(CircleShape)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.plus_icon),
                                contentDescription = null
                            )
                        }
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                        )
                        .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.PrimaryColor,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 30.dp, bottom = 30.dp)
                            .height(60.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        onClick = {
                            Toast.makeText(
                                context,
                                "Successfully added to cart",
                                Toast.LENGTH_SHORT
                            ).show()

                        },
                    ) {
                        Text(text = "Add to Cart", fontSize = 16.sp)
                    }
                }


            }


        }

    } else {
        Toast.makeText(context, state.errorMessage, Toast.LENGTH_SHORT).show()
    }


}