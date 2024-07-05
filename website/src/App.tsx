import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import WeatherInput from './Components/Input/Input'
import WeatherSearchButton from './Components/Buttons/Button'
import DisplayWeather from './Components/WeatherDisplay/DisplayWeather'
import { fetchWeaherData } from './api/api'
import 'dotenv/config'
export default function App(){
  //Collecting the weather State
  const [weather, setWeather] = useState("")
  const [weatherData, setWeatherData] = useState(null)

  function handleChange(e: React.ChangeEvent<HTMLInputElement>){
    setWeather(e.target.value)
  }

  async function handleSearch(){
    console.log(`Search initiated for ${weather}`)
   if(weather){
    const weatherAPI : string= import.meta.env.VITE_WEATHER_API || '';
    console.log('API KEY: ', weatherAPI);
    if (!weatherAPI){
      console.error(`API key is not set`);
      return;
    }
    const data = await fetchWeaherData(weather, weatherAPI)
    console.log(`Data fetched: ${data}`);
    setWeatherData(data);
   }
  }
  return(
    <>
      <div className=''>
          <WeatherInput userInput={weather} visualChange={handleChange}/>
         <WeatherSearchButton buttonClick={handleSearch}/>
         <DisplayWeather weatherData={weatherData}/>
      </div>
    </>
  )
}


