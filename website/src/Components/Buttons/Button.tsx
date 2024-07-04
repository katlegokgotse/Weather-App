import React from 'react'

interface ButtonProps {
    buttonClick: () => void
}

const WeatherSearchButton = ({buttonClick}: ButtonProps) => {
  return (
    <div>
        <input 
        type="button" 
        value="Search Weather in location" 
        onClick={buttonClick}/>
    </div>
  ) 
}

export default WeatherSearchButton