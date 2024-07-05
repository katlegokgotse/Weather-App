import React from 'react'

interface Props {

}

const DisplayWeather = ({weatherData} : { weatherData: any}) => {
  if (!weatherData) return null;
  return (
    <div>
      <h2>Weather in {weatherData.name}</h2>
      <p>Temperature: {weatherData.main.temp}°C</p>
      <p>Weather: {weatherData.weather[0].description}</p>
    </div>
  )
}

export default DisplayWeather