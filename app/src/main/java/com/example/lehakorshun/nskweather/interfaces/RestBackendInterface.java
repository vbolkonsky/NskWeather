package com.example.lehakorshun.nskweather.interfaces;

import com.example.lehakorshun.nskweather.model.Mmweather;
import com.example.lehakorshun.nskweather.utils.Constant;

import retrofit.Call;
import retrofit.http.GET;

public interface RestBackendInterface {

    @GET(Constant.PATH)
    Call<Mmweather> getWeather();

}
