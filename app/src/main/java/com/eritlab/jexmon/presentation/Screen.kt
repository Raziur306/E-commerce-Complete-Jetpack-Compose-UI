package com.eritlab.jexmon.presentation

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen("splash_screen")
    object SignInScreen : Screen("sign_in_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object HomeScreen : Screen("home_screen")
    object CartScreen : Screen("home_screen")
    object ProductScreen : Screen("product_screen")
    object OrderPlacedScreen : Screen("order_placed")
    object SignInSuccess : Screen("sign_success")
    object ForgetPasswordScreen : Screen("forget_password_screen")
    object OTPScreen : Screen("otp_screen")
}