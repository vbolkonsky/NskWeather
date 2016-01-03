package com.example.lehakorshun.nskweather.modules;

import android.app.Application;

import com.example.lehakorshun.nskweather.scopes.AppScope;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application app;

    private OkHttpClient okHttpClient;

    public AppModule(Application app) {
        this.app = app;

        okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    @AppScope
    public Application provideApplication() {
        return app;
    }

    @Provides
    @AppScope
    public OkHttpClient provideOkHttpClient() {

        return okHttpClient;
    }
}