package com.dongeul.pit_f.pit_f.presentation.weather_main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dongeul.pit_f.pit_f.domain.model.DayWeather
import com.dongeul.pit_f.pit_f.presentation.weather_main.components.WeatherHeaderScreen
import com.dongeul.pit_f.pit_f.presentation.weather_main.components.WeatherListItem

@Composable
fun WeatherMainScreen(
    navController: NavController,
    viewModel: WeatherMainViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(Modifier.fillMaxSize()) {

        LazyColumn(Modifier.fillMaxWidth()) {
            state.weatherList?.forEach {
                item {
                    WeatherHeaderScreen(headerName = it.cityName)
                }
                items(it.dayWeatherList) { dayWeather ->
                    WeatherListItem(dayWeather = dayWeather)
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}