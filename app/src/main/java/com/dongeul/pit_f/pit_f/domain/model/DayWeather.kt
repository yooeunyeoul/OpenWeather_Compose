package com.dongeul.pit_f.pit_f.domain.model

import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherDataDto
import org.threeten.bp.LocalDateTime

data class DayWeather(
    val displayDate: String,
    val tempMax: String,
    val tempMin: String,
    val iconInfo: String,
    val weatherState: String
)


fun WeatherDataDto.toDayWeather(): DayWeather {
    return DayWeather(
        displayDate = dt_txt.removeDateTime(),
        tempMax = main.temp_max.toString(),
        tempMin = main.temp_min.toString(),
        iconInfo = weather.firstOrNull()?.icon ?: "",
        weatherState = weather.firstOrNull()?.main ?: ""
    )
}

fun getDisplayDate(date: String): String {
    val parsedDate = LocalDateTime.parse(date)
    return "${parsedDate.dayOfWeek}${parsedDate.month}${parsedDate.dayOfMonth}"
}

fun String.removeDateTime():String {
    if (this.isNullOrEmpty()) {
        return ""
    }
    return substring(startIndex = 0, endIndex = this.indexOf(" "))
}

