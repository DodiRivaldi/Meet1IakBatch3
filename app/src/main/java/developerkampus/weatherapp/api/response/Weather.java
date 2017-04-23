package developerkampus.weatherapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Dodi Rivaldi on 23/04/2017.
 */

public class Weather {
    @SerializedName("main")
    private WeatherMain weatherMain;
    @SerializedName("weather")
    private ArrayList<WeatherItem> listWeather = new ArrayList<>();
    @SerializedName("city")
    private String city;

    public WeatherMain getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(WeatherMain weatherMain) {
        this.weatherMain = weatherMain;
    }

    public ArrayList<WeatherItem> getListWeather() {
        return listWeather;
    }

    public void setListWeather(ArrayList<WeatherItem> listWeather) {
        this.listWeather = listWeather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
