package com.dongeul.pit_f.pit_f.presentation

sealed class Screen(val route:String) {
    object WeatherMainScreen : Screen("weather_main")
}