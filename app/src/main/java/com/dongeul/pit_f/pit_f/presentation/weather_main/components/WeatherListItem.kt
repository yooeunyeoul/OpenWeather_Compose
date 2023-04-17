package com.dongeul.pit_f.pit_f.presentation.weather_main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dongeul.pit_f.pit_f.domain.model.DayWeather

@Composable
fun WeatherListItem(dayWeather: DayWeather) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dayWeather.displayDate,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(start = 8.dp)
            )
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(
                        id = dayWeather.iconInfo,
                    ),
                    contentDescription = "icon Image",
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.Bottom),
                )
                Text(
                    text = dayWeather.weatherState,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.align(Alignment.Bottom)
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text(
                        text = "Max:${dayWeather.tempMax}°C",
                        style = MaterialTheme.typography.button
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Min:${dayWeather.tempMin}°C",
                        style = MaterialTheme.typography.button
                    )
                }

            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color.LightGray)
        }
    }

}