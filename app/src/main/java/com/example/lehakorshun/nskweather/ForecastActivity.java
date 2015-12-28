package com.example.lehakorshun.nskweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lehakorshun.nskweather.helper.Helper;
import com.example.lehakorshun.nskweather.model.Forecast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForecastActivity extends AppCompatActivity {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.US);

    @Bind(R.id.forecastImage)
    ImageView forecastImage;

    @Bind(R.id.forecastDate)
    TextView forecastDate;

    @Bind(R.id.forecastTemperature)
    TextView forecastTemperature;

    @Bind(R.id.forecastWind)
    TextView forecastWind;

    @Bind(R.id.forecastPressure)
    TextView forecastPressure;

    @Bind(R.id.forecastPrecipitation)
    TextView forecastPrecipitation;

    @Bind(R.id.forecastRelwet)
    TextView forecastRelwet;

    @Bind(R.id.forecastHeat)
    TextView forecastHeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Forecast forecast = (Forecast) getIntent().getSerializableExtra("forecast");

        setForecastImage(forecast.getPhenomena().getCloudiness());
        setForecastDate(forecast.getYear(), forecast.getMonth(), forecast.getDay(), forecast.getHour());
        setForecastTemperature(forecast.getTemperature().getMax(), forecast.getTemperature().getMin());
        setForecastWind(forecast.getWind().getMax(), forecast.getWind().getMin(),
                forecast.getWind().getDirection());
        setForecastPressure(forecast.getPressure().getMax(), forecast.getPressure().getMin());
        setForecastRelwet(forecast.getRelwet().getMax(), forecast.getRelwet().getMin());
        setForecastHeat(forecast.getHeat().getMax(), forecast.getHeat().getMin());
    }

    private void setForecastImage(int cloudiness) {
        forecastImage.setImageResource(Helper.getImage(cloudiness));
    }

    private void setForecastDate(int year, int month, int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, 0);
        String date = dateFormat.format(calendar.getTime());
        forecastDate.setText(date);
    }

    private void setForecastTemperature(int max, int min) {
        String temperature = "Temperature: Max: " + max
                + " Min: " + min;
        forecastTemperature.setText(temperature);
    }

    private void setForecastWind(int max, int min, int direction) {
        String wind = "Wind: Max: " + max
                + " Min: " + min + " Direction: " +
                Helper.getWindDirection(direction);
        forecastWind.setText(wind);
    }

    private void setForecastPressure(int max, int min) {
        String pressure = "Pressure: Max: " + max
                + " Min: " + min;
        forecastPressure.setText(pressure);
    }

    private void setForecastPrecipitation() {

    }

    private void setForecastRelwet(int max, int min) {
        String pressure = "Relwet: Max: " + max
                + " Min: " + min;
        forecastPressure.setText(pressure);
    }

    private void setForecastHeat(int max, int min) {
        String pressure = "Heat: Max: " + max
                + " Min: " + min;
        forecastPressure.setText(pressure);
    }

}
