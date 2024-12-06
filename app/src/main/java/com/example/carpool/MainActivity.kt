package com.example.carpool
import MapScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "FirstScreen", builder = {
        composable("LoginScreen"){
            Login(navController)
        }
                composable("SignupScreen"){
                    Signup(navController)
                }
                composable("FirstScreen"){
                    FirstScreen(navController)
                }
                composable("ChooseScreen"){
                    Choose(navController)
                }
                composable("MapScreen"){
                    MapScreen(context,navController)
                }
                composable("ScheduleScreen"){
                    ScheduleScreen()
                }
            })


        }
    }
}