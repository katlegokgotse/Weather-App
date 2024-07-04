import React from 'react'

interface UserInputProps {
    userInput: string;
    visualChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}
const WeatherInput: React.FC<UserInputProps> = ( {userInput, visualChange}) => {
  return (
    <div>
        <input 
        type="text" 
        value={userInput}
        name="userInput" 
        id="userInput"
        className='WeatherInput'
        onChange={visualChange}
         />
    </div>
  )
}
export default WeatherInput;