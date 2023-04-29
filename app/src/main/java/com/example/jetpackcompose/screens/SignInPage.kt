package com.example.jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.component.CustomTextField
import com.example.jetpackcompose.navigation.Screen
import com.example.jetpackcompose.ui.theme.greyColor
import com.example.jetpackcompose.ui.theme.lightPrimary

@Composable
fun SignInPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Sign in with password",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize
        )
        BodySection(navController)
        footerSection()
    }
}

@Composable
fun BodySection(
    navController: NavController, modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var email by remember { mutableStateOf("") }
        CustomTextField(
            modifier = modifier,
            text = email,
            label = "Email",
            placeholder = "Enter you Email",
            onValueChange = {
                email = it
            }
        )
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(value = password, onValueChange = { password = it },
            modifier = modifier,
            label = {
                Text(
                    text = "Password"
                )
            }, placeholder = { Text(text = "Enter password") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = "password"
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.ic_visibility)
                else
                    painterResource(id = R.drawable.ic_visibility_off)
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, contentDescription = "visibility")
                }
            })
        var rememberChecked by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberChecked,
                onCheckedChange = { rememberChecked = !rememberChecked },
                enabled = true
            )
            Text(text = "Remember me", fontWeight = FontWeight.Bold)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(route = Screen.resetPassword.route) },
                text = "Reset password",
                textAlign = TextAlign.End,
                color = lightPrimary
            )
        }
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = greyColor)
        ) {
            Text(text = "SIGN IN", color = Color.White)
        }
    }
}

@Composable
fun footerSection() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(Color.Black)
            )
            Text(
                text = "or continue with",
                modifier = Modifier.padding(horizontal = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(Color.Black)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                painter = painterResource(id = R.drawable.facebook_icon),
                contentDescription = "",
                tint = Color.Unspecified
            )
            Icon(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "",
                tint = Color.Unspecified
            )
            Icon(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Don't have an account?")
                }
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Sign up")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 35.dp, top = 50.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun SignInPagePreview() {
    Surface {
        SignInPage(navController = rememberNavController())
    }
}