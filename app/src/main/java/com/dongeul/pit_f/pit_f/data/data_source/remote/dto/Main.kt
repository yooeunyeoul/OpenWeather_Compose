package com.dongeul.pit_f.pit_f.data.data_source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("grnd_level")
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    @SerialName("sea_level")
    val seaLevel: Int,
    val temp: Double,
    @SerialName("temp_kf")
    val tempKf: Double,
    @SerialName("temp_max")
    val temp_max: Double,
    @SerialName("temp_min")
    val temp_min: Double
)