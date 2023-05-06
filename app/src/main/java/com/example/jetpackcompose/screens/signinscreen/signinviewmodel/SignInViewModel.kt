package com.example.jetpackcompose.screens.signinscreen.signinviewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.jetpackcompose.navigation.Screen
import com.example.jetpackcompose.screens.signinscreen.model.SignInUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel : ViewModel() {

    private val _uistate = MutableStateFlow(SignInUiState())

    val uistate: StateFlow<SignInUiState> = _uistate.asStateFlow()

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun signIn(userEmail : String = email, userPassword : String = password) {
        email = userEmail
        password = userPassword
        _uistate.value.isEmailPasswordValid = email.isNotEmpty() && password.isNotEmpty()
    }




}