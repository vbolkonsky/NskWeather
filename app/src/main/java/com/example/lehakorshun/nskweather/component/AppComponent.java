package com.example.lehakorshun.nskweather.component;

import android.app.Application;

import com.example.lehakorshun.nskweather.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = {
                AppModule.class,
        }
)
@Singleton
public interface AppComponent {
    void inject(Application app);
}