package com.example.cleanarchitectureinaction.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cleanarchitectureinaction.data.mappers.toWeatherInfo
import com.example.cleanarchitectureinaction.data.remote.WeatherApi
import com.example.cleanarchitectureinaction.domain.repository.WeatherRepository
import com.example.cleanarchitectureinaction.domain.util.Resource
import com.example.cleanarchitectureinaction.domain.weather.WeatherInfo
import javax.inject.Inject
import kotlin.math.ln

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherInfo(lat: Double, lng: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, long = lng).toWeatherInfo()
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown Error")
        }
    }
}