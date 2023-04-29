package com.example.jetpackcompose.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(
    signUpText: String = "Sign up with Google",
    loadingText: String = "Creating account...",
    icon : Int = R.drawable.ic_google_logo,
    shape : Shape = Shapes.medium,
    backgroundColor : Color = MaterialTheme.colors.surface,
    borderColor : Color = Color.LightGray,
    progressIndicatorColor : Color = MaterialTheme.colors.primary,
    onClicked : () -> Unit
) {
    var clicked by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.clickable { clicked = !clicked },
        shape = shape,
        border = BorderStroke(1.dp, color = borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else signUpText)
            if (clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                onClicked()
            }
        }
    }
}

@Composable
@Preview
fun GoogleLogoPreview() {
    GoogleButton(onClicked = {})
}