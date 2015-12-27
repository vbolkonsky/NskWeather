package com.example.lehakorshun.nskweather.modules;

import com.example.lehakorshun.nskweather.interfaces.RestBackendInterface;
import com.example.lehakorshun.nskweather.model.Mmweather;
import com.example.lehakorshun.nskweather.model.Town;

import dagger.Module;
import dagger.Provides;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

@Module
public class TownModule {

    Town town = null;
    private static final String BASE_URL = "http://informer.gismeteo.ru";

    @Provides
    public Town provideTown() {
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        RestBackendInterface restBackendInterface = retrofit.create(RestBackendInterface.class);
        Call<Mmweather> call = restBackendInterface.getWeather();
        call.enqueue(new Callback<Mmweather>() {
            @Override
            public void onResponse(Response<Mmweather> response, Retrofit retrofit) {
                town = response.body().getTown();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        return town;
    }
}
