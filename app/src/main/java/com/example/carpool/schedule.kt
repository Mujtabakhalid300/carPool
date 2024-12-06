package com.example.carpool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScheduleScreen() {
    // State variables to hold schedule times for each day
    val initialTime = "9:41 AM"
    val homeToUniversityTimes = remember { mutableStateMapOf("M" to initialTime, "T" to initialTime, "W" to initialTime, "R" to initialTime, "F" to initialTime) }
    val universityToHomeTimes = remember { mutableStateMapOf("M" to initialTime, "T" to initialTime, "W" to initialTime, "R" to initialTime, "F" to initialTime) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Schedule", fontSize = 24.sp, )

        Spacer(modifier = Modifier.height(16.dp))
        ScheduleSection(
            title = "Departure Time (Home→University)",
            scheduleTimes = homeToUniversityTimes
        )

        Spacer(modifier = Modifier.height(32.dp))
        ScheduleSection(
            title = "Departure Time (University→Home)",
            scheduleTimes = universityToHomeTimes
        )
    }
}

@Composable
fun ScheduleSection(
    title: String,
    scheduleTimes: MutableMap<String, String>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title, fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            scheduleTimes.keys.forEach { day ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = day)
                    EditableTimeButton(
                        time = scheduleTimes[day] ?: "",
                        onTimeChange = { newTime ->
                            scheduleTimes[day] = newTime
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EditableTimeButton(
    time: String,
    onTimeChange: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    Button(onClick = { showDialog = true }) {
        Text(text = time)
    }

    if (showDialog) {
        TimePickerDialog(initialTime = time, onDismissRequest = { showDialog = false }, onTimeSelected = { newTime ->
            onTimeChange(newTime)
            showDialog = false
        })
    }
}

@Composable
fun TimePickerDialog(
    initialTime: String,
    onDismissRequest: () -> Unit,
    onTimeSelected: (String) -> Unit
) {
    var textState by remember { mutableStateOf(TextFieldValue(initialTime)) }
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = { Text(text = "Edit Time") },
        text = {
            Column {
                Text(text = "Enter time:")
                BasicTextField(
                    value = textState,
                    onValueChange = { textState = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
                        .padding(16.dp)
                )
            }
        },
        confirmButton = {
            Button(onClick = { onTimeSelected(textState.text) }) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = { onDismissRequest() }) {
                Text("Cancel")
            }
        }
    )
}