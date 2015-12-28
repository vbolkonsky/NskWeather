package com.example.lehakorshun.nskweather;

import android.app.Application;
import android.content.Context;

import com.example.lehakorshun.nskweather.component.AppComponent;
import com.example.lehakorshun.nskweather.component.DaggerAppComponent;
import com.example.lehakorshun.nskweather.modules.AppModule;

public class App extends Application {

    private AppComponent component;

    @Override public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}