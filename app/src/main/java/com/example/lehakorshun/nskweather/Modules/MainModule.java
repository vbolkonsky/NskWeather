package com.example.lehakorshun.nskweather.modules;

import android.content.Context;

import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.utils.Constant;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    public Retrofit provideRetrofit() {

        return new  Retrofit.Builder()
                .baseUrl(Constant.URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    public WeatherAdapter provideWeatherAdapter() {

        return new WeatherAdapter(context);
    }
}
