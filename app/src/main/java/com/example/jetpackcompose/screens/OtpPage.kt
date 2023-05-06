package com.example.jetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.component.OTPScreen
import com.example.jetpackcompose.navigation.Screen
import com.example.jetpackcompose.ui.theme.lightPrimary

@Composable
fun OtpPage(navController: NavController,modifier : Modifier = Modifier){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxWidth(fraction = .50f)
                .padding(15.dp)

        ) {
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                text = "Enter Verification Code",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h3.fontSize
            )
            Text(modifier = Modifier.padding(vertical = 15.dp), text = "Enter code that we have sent to your email vidyadharjogi101@gmail.com")
            var text by remember { mutableStateOf("") }
            Spacer(modifier = Modifier.height(15.dp))
            OTPScreen()
            Button(
                onClick = { navController.navigate(route = Screen.otpScreen.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightPrimary)
            ) {
                Text(text = "SUBMIT", color = Color.White)
            }
        }

    }



@Preview(showBackground = true)
@Composable
fun OtpPagePreview(){
    OtpPage(navController = rememberNavController())
}
