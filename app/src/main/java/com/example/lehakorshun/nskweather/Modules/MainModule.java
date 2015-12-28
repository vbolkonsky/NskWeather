package com.example.lehakorshun.nskweather.modules;

import android.content.Context;

import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.utils.Constant;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

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

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);

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
