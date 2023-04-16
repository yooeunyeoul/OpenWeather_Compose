package com.dongeul.pit_f.pit_f.domain.model

import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherResultDto

data class Weather(
    val cityName: String,
    val dayWeatherList: List<DayWeather>
)


fun WeatherResultDto.toWeather(): Weather {
    return Weather(
        cityName = city?.name ?: "",
        dayWeatherList = list?.map { it.toDayWeather() }?.distinctBy { it.displayDate } ?: listOf()
    )
}