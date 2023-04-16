package com.dongeul.pit_f.pit_f.domain.use_case.get_weather

import com.dongeul.pit_f.pit_f.common.Constants
import com.dongeul.pit_f.pit_f.common.Resource
import com.dongeul.pit_f.pit_f.data.data_source.remote.dto.WeatherResultDto
import com.dongeul.pit_f.pit_f.domain.model.Weather
import com.dongeul.pit_f.pit_f.domain.model.toWeather
import com.dongeul.pit_f.pit_f.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {
    operator fun invoke(cityNameList: List<String>): Flow<Resource<List<Weather>>> =
        flow {
            emit(Resource.Loading())
            coroutineScope {
                val weatherListOfThreeCities = mutableListOf<Weather>()
                val runningTasks = cityNameList.map { cityName ->
                    async(Dispatchers.IO) {
                        val response =
                            repository.getItems(appId = Constants.appKey, cityName = cityName)
                        response
//                        WeatherResultDto()
                    }
                }
                val responses = runningTasks.awaitAll()
                responses.forEach { weatherResultDto ->
                    if (weatherResultDto.cod != "200") {
                        emit(Resource.Error(message = "Api Error Response"))
                        return@coroutineScope
                    } else {
                        val eachCityOfWeather = weatherResultDto.toWeather()
                        weatherListOfThreeCities.add(eachCityOfWeather)
                    }
                }
                emit(Resource.Success(data = weatherListOfThreeCities))
            }
        }
}

