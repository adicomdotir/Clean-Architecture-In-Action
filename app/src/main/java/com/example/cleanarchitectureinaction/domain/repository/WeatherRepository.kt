package com.example.cleanarchitectureinaction.domain.repository

import com.example.cleanarchitectureinaction.domain.util.Resource
import com.example.cleanarchitectureinaction.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherInfo(lat: Double, lng: Double): Resource<WeatherInfo>
}
