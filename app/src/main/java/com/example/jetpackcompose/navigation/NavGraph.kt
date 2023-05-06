package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.screens.OtpPage
import com.example.jetpackcompose.screens.signinscreen.SignInPage
import com.example.jetpackcompose.resetpasswordscreen.ForgotPasswordPage

@Composable
fun SetupNavGraph(navController : NavHostController){
    NavHost(navController = navController , startDestination = Screen.signIn.route){
        composable(route = Screen.signIn.route){
            SignInPage(navController = navController)
        }
        composable(route = Screen.resetPassword.route){
            ForgotPasswordPage(navController = navController)
        }
        composable(route = Screen.otpScreen.route){
            OtpPage(navController = navController)
        }

    }
}