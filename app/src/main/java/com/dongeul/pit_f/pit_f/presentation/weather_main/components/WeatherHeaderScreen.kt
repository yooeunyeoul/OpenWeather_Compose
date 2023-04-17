package com.dongeul.pit_f.pit_f.presentation.weather_main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WeatherHeaderScreen(headerName: String) {
    Column(modifier = Modifier.background(color = Color.LightGray)) {
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.DarkGray, thickness = 4.dp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = headerName,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.DarkGray, thickness = 4.dp)
    }
}