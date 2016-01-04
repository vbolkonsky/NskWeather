package com.example.lehakorshun.nskweather.modules;

import android.app.Application;

import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.scopes.ActivityScope;
import com.example.lehakorshun.nskweather.utils.Constant;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

@Module
public class MainModule {

    @Provides
    @ActivityScope
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {

        return new  Retrofit.Builder()
                .baseUrl(Constant.URL)
                .client(okHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    @ActivityScope
    public WeatherAdapter provideWeatherAdapter(Application app) {
        return new WeatherAdapter(app);
    }
}
