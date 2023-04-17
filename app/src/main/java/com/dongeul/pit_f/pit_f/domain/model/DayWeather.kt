package com.dongeul.pit_f.pit_f.domain.model

import androidx.annotation.DrawableRes
import com.dongeul.pit_f.R
import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherDataDto
import org.threeten.bp.LocalDateTime
import kotlin.math.roundToInt

data class DayWeather(
    val displayDate: String,
    val tempMax: String,
    val tempMin: String,
    @DrawableRes val iconInfo: Int,
    val weatherState: String
)


fun WeatherDataDto.toDayWeather(): DayWeather {
    return DayWeather(
        displayDate = dt_txt.removeDateTime(),
        tempMax = main.temp_max.roundToInt().toString(),
        tempMin = main.temp_min.roundToInt().toString(),
        iconInfo = when {
            weather.firstOrNull()?.main?.lowercase()?.contains("rain") == true -> {
                R.drawable.rain
            }
            weather.firstOrNull()?.main?.lowercase()?.contains("snow") == true -> {
                R.drawable.snow
            }
            weather.firstOrNull()?.main?.lowercase()?.contains("clear") == true -> {
                R.drawable.clear
            }
            weather.firstOrNull()?.main?.lowercase()?.contains("clouds") == true -> {
                R.drawable.cloud
            }
            else -> {
                R.drawable.alien
            }
        },
        weatherState = weather.firstOrNull()?.main ?: ""
    )
}

fun getDisplayDate(date: String): String {
    val parsedDate = LocalDateTime.parse(date)
    return "${parsedDate.dayOfWeek}${parsedDate.month}${parsedDate.dayOfMonth}"
}

fun String.removeDateTime(): String {
    if (this.isNullOrEmpty()) {
        return ""
    }
    return substring(startIndex = 0, endIndex = this.indexOf(" "))
}

