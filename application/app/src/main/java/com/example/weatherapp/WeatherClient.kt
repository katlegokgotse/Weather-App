package com.example.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherClient{
    private const val BASE_UTL = "https://api.openweathermap.org/data/2.5/"

    val retrofitCall: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_UTL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
object WeatherApiClient{
    val weatherService: WeatherServices by lazy{
        WeatherClient.retrofitCall.create(WeatherServices::class.java);
    }
}
