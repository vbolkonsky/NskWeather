package com.example.lehakorshun.nskweather.interfaces;

import com.example.lehakorshun.nskweather.model.Mmweather;

import retrofit.Call;
import retrofit.http.GET;

public interface RestBackendInterface {

    @GET("/xml/29634_1.xml")
    Call<Mmweather> getWeather();

}
