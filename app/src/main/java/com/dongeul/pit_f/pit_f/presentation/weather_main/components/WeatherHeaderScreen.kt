package com.dongeul.pit_f.pit_f.presentation.weather_main.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun WeatherHeaderScreen(headerName: String) {
    Text(text = headerName, style = MaterialTheme.typography.h4)
}