package com.dongeul.pit_f.pit_f.data.data_source.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class WeatherResultDto(
    val city: City?=null,
    val cnt: Int?=null,
    val cod: String?=null,
    val list: List<WeatherDataDto>?=null,
    val message: Int?=null
)

