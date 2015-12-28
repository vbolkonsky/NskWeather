package com.example.lehakorshun.nskweather.component;

import com.example.lehakorshun.nskweather.ActivityScope;
import com.example.lehakorshun.nskweather.MainActivity;
import com.example.lehakorshun.nskweather.adapter.WeatherAdapter;
import com.example.lehakorshun.nskweather.modules.MainModule;

import dagger.Component;
import retrofit.Retrofit;

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
    Retrofit provideRetrofit();
    WeatherAdapter provideWeatherAdapter();
}
