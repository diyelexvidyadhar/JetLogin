package com.example.jetpackcompose.screens.signinscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.jetpackcompose.screens.signinscreen.signinviewmodel.SignInViewModel
import com.example.jetpackcompose.ui.theme.greyColor
import com.example.jetpackcompose.ui.theme.lightPrimary
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignInPage(viewModel: SignInViewModel = viewModel(), navController: NavController) {

    val signInUiState by viewModel.uistate.collectAsState()
    val context = LocalContext.current

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
        BodySection(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 8.dp),
            userEmail = viewModel.email,
            onEmailChange = { viewModel.signIn(userEmail = it) },
            userPassword = viewModel.password,
            onPasswordChange = { viewModel.signIn(userPassword = it) },
            onSignInClick = { showToast(context = context, text = "sign in clicked") },
            isSignInButtonEnabled = signInUiState.isEmailPasswordValid,
            resetPassword = { navController.navigate(Screen.resetPassword.route) })
        footerSection(
            onFacebookIconClicked = { showToast(context = context, text = "Login with facebook") },
            onGoogleIconClicked = { showToast(context = context, text = "Login with google") },
            onAppleIconClicked = { showToast(context = context, text = "Login with apple") })
    }
}

@Composable
fun BodySection(
    modifier: Modifier = Modifier,
    userEmail: String,
    onEmailChange: (String) -> Unit,
    userPassword: String,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    isSignInButtonEnabled: Boolean,
    resetPassword: () -> Unit

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CustomTextField(
            modifier = modifier,
            text = userEmail,
            label = "Email",
            placeholder = "Enter you Email",
            onValueChange = {
                onEmailChange(it)
            }
        )
        PasswordTextField(
            modifier = modifier,
            userPassword = userPassword,
            onPasswordChange = onPasswordChange
        )
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
                    .wrapContentWidth(align = Alignment.End)
                    .clickable { resetPassword() },
                text = "Reset password",
                textAlign = TextAlign.End,
                color = lightPrimary
            )
        }
        Button(
            onClick = onSignInClick,
            modifier = Modifier.fillMaxWidth(),
            colors = if (isSignInButtonEnabled) ButtonDefaults.buttonColors(backgroundColor = lightPrimary)
            else ButtonDefaults.buttonColors(
                backgroundColor = greyColor
            ),
            enabled = isSignInButtonEnabled
        ) {
            Text(text = "SIGN IN", color = Color.White)
        }
    }
}

@Composable
fun footerSection(
    onFacebookIconClicked: () -> Unit,
    onGoogleIconClicked: () -> Unit,
    onAppleIconClicked: () -> Unit
) {
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
                modifier = Modifier.clickable { onFacebookIconClicked() },
                painter = painterResource(id = R.drawable.facebook_icon),
                contentDescription = "",
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier.clickable { onGoogleIconClicked() },
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "",
                tint = Color.Unspecified
            )
            Icon(
                modifier = Modifier.clickable { onAppleIconClicked() },
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

@Composable
fun PasswordTextField(
    userPassword: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(value = userPassword, onValueChange = { onPasswordChange(it) },
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
}

fun showToast(context: Context, text: String) {
    val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
    toast.show()
}

@Preview
@Composable
fun SignInPagePreview() {
    Surface {
        SignInPage(navController = rememberNavController())
    }
}