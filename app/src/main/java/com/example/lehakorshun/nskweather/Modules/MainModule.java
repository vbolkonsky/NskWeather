package com.example.lehakorshun.nskweather.modules;

import com.example.lehakorshun.nskweather.App;
import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.utils.Constant;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

@Module
public class MainModule {

    @Inject
    App context;

    @Inject
    OkHttpClient okHttpClient;

    @Provides
    public Retrofit provideRetrofit() {
        return new  Retrofit.Builder()
                .baseUrl(Constant.URL)
                .client(okHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    public WeatherAdapter provideWeatherAdapter() {
        return new WeatherAdapter(context);
    }
}
