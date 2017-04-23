package developerkampus.weatherapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dodi Rivaldi on 23/04/2017.
 */

public class ApiService {

    public static String API_KEY="29d85fcc7fd47e7b064b21a661f54b63";
    public static String BASE_URL="http://api.openweathermap.org";

    public static <S> S createService (Class<S> serviceClass){

        final OkHttpClient okHttpClient = new OkHttpClient
                .Builder().readTimeout(100, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(serviceClass);
    }

}
