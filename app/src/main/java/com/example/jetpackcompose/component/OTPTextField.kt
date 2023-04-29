package com.example.jetpackcompose.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun OTPScreen() {
        var otpText by remember { mutableStateOf("") }
        BasicTextField(
            value = otpText,
            onValueChange = { if (it.length <= 4) otpText = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            decorationBox = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    repeat(4) { index ->
                        val char = when {
                            index >= otpText.length -> ""
                            else -> otpText[index].toString()
                        }
                        var isFocused = otpText.length == index
                        Text(
                            modifier = Modifier
                                .width(80.dp)
                                .height(50.dp)
                                .border(
                                    if (isFocused) 2.dp else 1.dp,
                                    if (isFocused) Color.DarkGray else Color.LightGray,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(2.dp),
                            text = char,
                            style = MaterialTheme.typography.h4,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        )
    }



@Preview(showBackground = true)
@Composable
fun OtpScreenPreview() {
    OTPScreen()
}


