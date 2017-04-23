package developerkampus.weatherapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import developerkampus.weatherapp.api.request.WeatherRequest;
import developerkampus.weatherapp.api.response.Weather;

public class MainActivity extends AppCompatActivity
    implements WeatherRequest.OnWeatherRequestListener{

    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;
    @BindView(R.id.tv_main)
    TextView tvMain;
    @BindView(R.id.tv_temp)
    TextView tvTemp;

    private ProgressDialog progressDialog;
    private WeatherRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        request = new WeatherRequest(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Harap tunggu....");
        progressDialog.show();

        String city = "Londok, UK";
        request.CallApi(city);
    }

    @Override
    public void onSucces(Weather weatherResponse) {
        progressDialog.dismiss();
        tvCity.setText(weatherResponse.getCity());
        tvDescription.setText("Desc : "+weatherResponse.getListWeather().get(0).getDescription());
        double degrees = weatherResponse.getWeatherMain().getTemp()-273;
        tvTemp.setText("Temp : "+degrees+" C");
        tvHumidity.setText("Humidity : "+weatherResponse.getWeatherMain().getHumidity()+" %");
        tvMain.setText("Main : "+weatherResponse.getListWeather().get(0).getMain());
    }

    @Override
    public void onFailure(String message) {

    }
}
