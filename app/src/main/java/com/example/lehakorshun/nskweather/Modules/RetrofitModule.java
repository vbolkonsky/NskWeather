package com.example.lehakorshun.nskweather.modules;

import com.example.lehakorshun.nskweather.utils.Constant;

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
