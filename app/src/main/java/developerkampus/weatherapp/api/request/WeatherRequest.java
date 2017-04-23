package developerkampus.weatherapp.api.request;

import developerkampus.weatherapp.api.ApiCLient;
import developerkampus.weatherapp.api.ApiService;
import developerkampus.weatherapp.api.response.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dodi Rivaldi on 23/04/2017.
 */

public class WeatherRequest {
    private ApiCLient apiCLient;
    private Call<Weather> request;
    private OnWeatherRequestListener listener;

    public interface OnWeatherRequestListener{
        void onSucces(Weather weatherResponse);
        void onFailure(String message);
    }

    public WeatherRequest(OnWeatherRequestListener listener){
        apiCLient = ApiService.createService(ApiCLient.class);
        this.listener = listener;
    }

    public void CallApi(String call){
        request = apiCLient.getWeather(call,ApiService.API_KEY);
        request.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response!=null && response.isSuccessful()){
                    Weather weather = response.body();
                    listener.onSucces(weather);
                }

                else {
                    listener.onFailure("Failed");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                String errorMessage = t.getMessage() !=null?
                        t.getMessage():"Unable to connect to server";
                listener.onFailure(errorMessage);
            }
        });
    }
}
