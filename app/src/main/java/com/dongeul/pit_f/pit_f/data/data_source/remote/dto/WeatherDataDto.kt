package com.dongeul.pit_f.pit_f.data.data_source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataDto (
    val clouds: Clouds,
    val dt: Int,
    @SerialName("dt_txt")
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val sys: Sys,
    val visibility: Int,
    val weather: List<WeatherDto>,
    val wind: Wind
)

