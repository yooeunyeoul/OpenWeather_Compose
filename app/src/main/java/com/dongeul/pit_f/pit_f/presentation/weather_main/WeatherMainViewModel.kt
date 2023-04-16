package com.dongeul.pit_f.pit_f.presentation.weather_main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dongeul.pit_f.pit_f.common.Resource
import com.dongeul.pit_f.pit_f.domain.use_case.get_weather.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class WeatherMainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WeatherMainState())
    val state: State<WeatherMainState> = _state

    private val cityNameList = listOf("Seoul", "London", "Chicago")

    init {
        getWeathers(cityNameList = cityNameList)

    }

    private fun getWeathers(cityNameList: List<String>) {
        getWeatherUseCase(cityNameList = cityNameList).onEach { result ->
            when (result) {


                is Resource.Success -> {
                    _state.value = state.value.copy(
                        weatherList = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value =
                        state.value.copy(error = result.message ?: "error occur", isLoading = false)
                }
                is Resource.Loading -> {
                    _state.value = state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}