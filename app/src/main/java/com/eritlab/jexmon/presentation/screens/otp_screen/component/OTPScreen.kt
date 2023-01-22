package com.eritlab.jexmon.presentation.screens.otp_screen.component


import android.os.CountDownTimer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eritlab.jexmon.presentation.common.CustomDefaultBtn
import com.eritlab.jexmon.presentation.common.component.DefaultBackArrow
import com.eritlab.jexmon.presentation.graphs.auth_graph.AuthScreen
import com.eritlab.jexmon.presentation.screens.sign_in_screen.component.OTPTexField
import com.eritlab.jexmon.presentation.ui.theme.PrimaryColor
import com.eritlab.jexmon.presentation.ui.theme.TextColor


@Composable
fun OTPScreen(navController: NavController) {
    //otp mutable list
    var otp1 by remember { mutableStateOf(TextFieldValue("")) }
    var otp2 by remember { mutableStateOf(TextFieldValue("")) }
    var otp3 by remember { mutableStateOf(TextFieldValue("")) }
    var otp4 by remember { mutableStateOf(TextFieldValue("")) }
    var otp5 by remember { mutableStateOf(TextFieldValue("")) }
    val focusRequester1 = FocusRequester()
    val focusRequester2 = FocusRequester()
    val focusRequester3 = FocusRequester()
    val focusRequester4 = FocusRequester()
    val focusRequester5 = FocusRequester()

    //count down
    val timer = object : CountDownTimer(12000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {

        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Box(modifier = Modifier.weight(0.5f)) {
                DefaultBackArrow {
                    //     navController.popBackStack()
                }
            }
            Box(modifier = Modifier.weight(1.0f)) {
                Text(
                    text = "OTP Verification",
                    color = MaterialTheme.colors.TextColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "OTP Verification", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(
            text = buildAnnotatedString {
                append("We sent your code to +8801737-***\nThis code is expired in ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.PrimaryColor,
                    )
                ) {
                    append("120s")
                }
            },
            color = MaterialTheme.colors.TextColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OTPTexField(focusRequester = focusRequester1) { newText ->
                otp1 = newText
                if (otp1.text.isNotEmpty()) {
                    focusRequester2.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester2) { newText ->
                otp2 = newText
                if (otp2.text.length == 1) {
                    focusRequester3.requestFocus()
                } else {
                    focusRequester1.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester3) { newText ->
                otp3 = newText
                if (otp3.text.length == 1) {
                    focusRequester4.requestFocus()
                } else {
                    focusRequester2.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester4) { newText ->
                otp4 = newText
                if (otp4.text.length == 1) {
                    focusRequester5.requestFocus()
                } else {
                    focusRequester3.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester5) { newText ->
                otp5 = newText
                if (otp5.text.isEmpty()) {
                    focusRequester4.requestFocus()
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        CustomDefaultBtn(shapeSize = 50f, btnText = "Verify") {
            if ((otp1.text + otp2.text + otp3.text + otp4.text + otp5.text).length == 5) {
                navController.navigate(AuthScreen.SignInScreen.route)
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Text(
            text = "Resend OTP Code",
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = MaterialTheme.colors.TextColor,
            fontWeight = FontWeight(500),
            modifier = Modifier.clickable {

            })
    }
}