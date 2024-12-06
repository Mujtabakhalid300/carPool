package com.example.carpool

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


fun checkCredSignup(email: String, password: String, navController: NavController, context: android.content.Context) {
    if (email == "mujtaba" && password == "") {
        navController.navigate("SignupScreen")
    } else {
        Toast.makeText(context, "Incorrect email or password", Toast.LENGTH_SHORT).apply {
            setGravity(android.view.Gravity.TOP or android.view.Gravity.CENTER_HORIZONTAL, 0, 100)
            show()
        }
    }
}

@Composable
fun Signup(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    Scaffold(
        topBar = {
            BackButtonTopBar(navController = navController)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize())
        {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Ensure padding from Scaffold is applied
                    .padding(20.dp), // Additional padding for spacing
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Signup with your Email",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(25.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(25.dp))

                // Add input fields and buttons here
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(25.dp))
                // Add input fields and buttons here
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text("By signing up. you agree to the Terms of service and Privacy policy." , color = Color.Blue, modifier = Modifier.padding(top = 10.dp))
                Spacer(modifier = Modifier.height(25.dp))
                Button(onClick = { checkCredSignup(email, password, navController, context) },
                    modifier = Modifier

                        .fillMaxWidth()
                        ) {
                    Text("Signup", textAlign = TextAlign.Center)

                }
            }

        }


    }
}
