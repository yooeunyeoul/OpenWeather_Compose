package com.dongeul.pit_f.pit_f.data.repository

import com.dongeul.pit_f.pit_f.data.data_source.remote.WeatherApi
import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.ItemsDto
import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherResultDto
import com.dongeul.pit_f.pit_f.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getItems(appId: String, cityName: String): WeatherResultDto {
        return api.getWeather(appId, cityName)
    }

}