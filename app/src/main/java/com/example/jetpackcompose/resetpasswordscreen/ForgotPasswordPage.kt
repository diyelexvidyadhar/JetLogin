package com.example.jetpackcompose.resetpasswordscreen

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
import com.example.jetpackcompose.navigation.Screen
import com.example.jetpackcompose.component.CustomTextField
import com.example.jetpackcompose.ui.theme.lightPrimary

@Composable
fun ForgotPasswordPage(navController: NavController, modifier: Modifier = Modifier) {
Surface(modifier = Modifier.fillMaxSize().padding(15.dp)) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxWidth(fraction = .50f)

    ) {
        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Forgot your password?",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize
        )
        Text(modifier = Modifier.padding(vertical = 15.dp), text = "No worries you just need to type your email address or username and we will send the verification code.")
        var text by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(15.dp))
        CustomTextField(
            text = text,
            label = "Email",
            placeholder = "enter your Email",
            onValueChange = { text = it })
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
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPagePreview() {
    ForgotPasswordPage(navController = rememberNavController())
}