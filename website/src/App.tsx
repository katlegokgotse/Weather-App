import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import WeatherInput from './Components/Input/Input'
import WeatherSearchButton from './Components/Buttons/Button'
import DisplayWeather from './Components/WeatherDisplay/DisplayWeather'

export default function App(){
  const [weather, setWeather] = useState("")

  function handleChange(e: React.ChangeEvent<HTMLInputElement>){
    setWeather(e.target.value)
  }
  return(
    <>
      <div className=''>
          <WeatherInput userInput={weather} visualChange={handleChange}/>
          <WeatherSearchButton/>
          <DisplayWeather />
      </div>
    </>
  )
}
