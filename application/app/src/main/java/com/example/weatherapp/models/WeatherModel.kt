package com.example.weatherapp.models
data class CountryWeather(
    val coordinates: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,
)

data class Coordinates(
    val lon: Double,
    val lat: Double,
)

data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)

data class Main(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Long,
    val humidity: Long,
)

data class Wind(
    val speed: Double,
    val deg: Long,
)

data class Clouds(
    val all: Long,
)

data class Sys(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)

