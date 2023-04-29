package com.example.jetpackcompose.navigation

sealed class Screen(val route : String ){
    object signIn : Screen(route = "sign_in_Screen")
    object signUp : Screen(route = "sign_up_screen")
    object resetPassword : Screen(route = "reset_password_screen")
    object otpScreen : Screen(route = "otp_screen")
}
