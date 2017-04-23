package developerkampus.weatherapp.api;

import developerkampus.weatherapp.api.response.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dodi Rivaldi on 23/04/2017.
 */

public interface ApiCLient {
    @GET("/data/2.5/weather")
    Call<Weather> getWeather (@Query("q") String q,
                              @Query("appid") String appId);
}
