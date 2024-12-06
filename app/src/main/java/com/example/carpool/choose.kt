package com.example.carpool

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Choose(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Content centered in the screen
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Your ride, Your choice",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { navController.navigate("LoginScreen") },
                modifier = Modifier.width(300.dp)) {
                Text(text = "Login",
                    fontWeight = FontWeight.Bold
                    )
            }
            Button(onClick = { navController.navigate("SignupScreen")},
                modifier = Modifier.width(300.dp)) {
                Text(text = "Signup", fontWeight = FontWeight.Bold)
            }
        }


    }
}

