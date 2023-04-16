package com.dongeul.pit_f.pit_f.domain.repository

import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherResultDto

interface WeatherRepository {
    suspend fun getItems(appId: String, cityName: String): WeatherResultDto
}