package com.example.lehakorshun.nskweather.modules;

import com.example.lehakorshun.nskweather.App;
import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.utils.Constant;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

@Module
public class MainModule {

    private static Retrofit retrofit = null;
    private static WeatherAdapter weatherAdapter = null;

    @Inject
    App app;

    @Provides
    public Retrofit provideRetrofit() {

        if (retrofit == null) {
            retrofit = new  Retrofit.Builder()
                    .baseUrl(Constant.URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    @Provides
    public WeatherAdapter provideWeatherAdapter() {
        if (weatherAdapter == null) {
            weatherAdapter = new WeatherAdapter(app);
        }

        return weatherAdapter;
    }
}
