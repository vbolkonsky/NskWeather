package com.example.lehakorshun.nskweather.Modules;

import com.example.lehakorshun.nskweather.Utils.Constant;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

@Module
public class RetrofitModule {

    private static Retrofit retrofit = null;

    @Provides
    public Retrofit provideTown() {

        if (retrofit != null) {
            retrofit = new  Retrofit.Builder()
                    .baseUrl(Constant.URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
