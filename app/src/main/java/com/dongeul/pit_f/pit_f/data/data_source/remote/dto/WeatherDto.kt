package com.dongeul.pit_f.pit_f.data.data_source.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)