package com.example.carpool

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons // Import required
import androidx.compose.material.icons.filled.ArrowBack // Import required
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackButtonTopBar(

    navController: NavController
) {
    TopAppBar(
        title = { Text("Back") },
        navigationIcon = {
            IconButton(onClick = {navController.popBackStack()}) { // Use the onBackClick lambda
                Icon(
                    imageVector = Icons.Filled.ArrowBack, // Corrected Icon reference
                    contentDescription = "Back"
                )
            }
        }
    )
}
