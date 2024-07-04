package com.example.weatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.models.CountryWeather
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val webAPI : String = "f69bae65c18c82c3db17f0fed4ceefb5"
    private var location : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtLocation = findViewById<EditText>(R.id.edtWeatherInput)
        val submitButton = findViewById<Button>(R.id.btnGetWeather)
        submitButton.setOnClickListener {

            location = edtLocation.text.toString().trim()
            if (location.isNotEmpty()){
                lifecycleScope.launch(Dispatchers.IO){
                    fetchWeather(webAPI, location)
                }
            }
        }
       // fetchWeather(webAPI, location)
    }
    private fun fetchWeather(web: String, location: String){
        val callApi = WeatherApiClient.weatherService.getWeather(location, web)
        callApi.enqueue(object : Callback<CountryWeather> {
            override fun onResponse(call: Call<CountryWeather>, response: Response<CountryWeather>) {
                if (response.isSuccessful){
                    val weather = response.body()
                    weather?.let {
                        val weatherDescription = it.weather[0].description
                        val weatherTemperature = it.main.temp
                        val weatherLocation = it.name
                        val weatherCoordinates = it.coordinates
                        val isSunRise = it.sys.sunrise
                        Toast.makeText(this@MainActivity, "$weatherDescription, $weatherTemperature, $weatherLocation, $weatherCoordinates, $isSunRise", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this@MainActivity, "Failed to get weather data", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(p0: Call<CountryWeather>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }

        })
        }
    }