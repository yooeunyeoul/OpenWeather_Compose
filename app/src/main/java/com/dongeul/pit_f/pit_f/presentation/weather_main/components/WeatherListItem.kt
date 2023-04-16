package com.dongeul.pit_f.pit_f.presentation.weather_main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dongeul.pit_f.pit_f.domain.model.DayWeather

@Composable
fun WeatherListItem(dayWeather: DayWeather) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "${dayWeather.displayDate}",
                style = MaterialTheme.typography.h4
            )
            Row(Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(dayWeather.iconInfo)
                        .crossfade(true).build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                )
                Text(text = dayWeather.weatherState, style = MaterialTheme.typography.button)
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.weight(1f)) {
                    Text(text = "Max:${dayWeather.tempMax}°C", style = MaterialTheme.typography.button)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Min:${dayWeather.tempMin}°C", style = MaterialTheme.typography.button)
                }

            }
        }
    }

}