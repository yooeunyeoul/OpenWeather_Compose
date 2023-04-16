package com.dongeul.pit_f.pit_f.data.data_source.remote

import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.ItemsDto
import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/forecast")
    suspend fun getWeather(
        @Query("appId") id: String,
        @Query("q") cityName: String,
        @Query("units") units: String = "metric"
    ): WeatherResultDto
}