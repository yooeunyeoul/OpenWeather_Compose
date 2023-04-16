package com.dongeul.pit_f.pit_f.presentation.weather_main

import com.dongeul.pit_f.pit_f.domain.model.Weather

data class WeatherMainState(
    val isLoading: Boolean = false,
    val weatherList: List<Weather>? = null,
    val error: String = ""
) {
}