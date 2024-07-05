export async function fetchWeaherData(cityName: string, apiKey:string) {
    try{
       let response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${apiKey}`);
       if (!response.ok){
         throw new Error(`Network response was not ok ${response.statusText}`);
       }
       let data = await response.json();
       return data;
    }catch(e){
       console.error(e)
       return null;
   }
}