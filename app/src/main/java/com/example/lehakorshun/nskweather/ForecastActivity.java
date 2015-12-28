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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Forecast forecast = (Forecast) getIntent().getSerializableExtra("forecast");

        forecastImage.setImageResource(Helper.getImage(forecast.getPhenomena().getCloudiness()));

        Calendar calendar = Calendar.getInstance();
        calendar.set(forecast.getYear(), forecast.getMonth(), forecast.getDay(),
                forecast.getHour(), 0);
        String date = dateFormat.format(calendar.getTime());
        forecastDate.setText(date);

        String temperature = "Temperature: Max: " + forecast.getTemperature().getMax()
                + " Min: " + forecast.getTemperature().getMin();
        forecastTemperature.setText(temperature);

        String wind = "Wind: Max: " + forecast.getWind().getMax()
                + " Min: " + forecast.getWind().getMin();
        forecastWind.setText(wind);
    }

}
