package com.example.lehakorshun.nskweather.component;

import com.example.lehakorshun.nskweather.modules.RetrofitModule;

import dagger.Component;
import retrofit.Retrofit;

@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {
    Retrofit provideRetrofit();
}