package com.example.weatherapp

import com.example.weatherapp.models.CountryWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServices {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): Response<CountryWeather>

}