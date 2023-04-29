package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.navigation.SetupNavGraph
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                    navController = rememberNavController()
                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                    Scaffold(topBar = {
                        TopAppBar(navigationIcon = {
                            if (currentBackStackEntry != null) {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_arrow_back),
                                        contentDescription = null
                                    )
                                }
                            } else {
                                null
                            }
                        }, title = {  }, backgroundColor = Color.Transparent, elevation = 0.dp)
                    }) {
                        SetupNavGraph(navController = navController)
                    }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {

    }
}