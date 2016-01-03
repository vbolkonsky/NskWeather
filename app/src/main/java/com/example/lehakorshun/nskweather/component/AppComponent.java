package com.example.lehakorshun.nskweather.component;

import android.app.Application;

import com.example.lehakorshun.nskweather.modules.AppModule;
import com.example.lehakorshun.nskweather.scopes.AppScope;

import dagger.Component;

@Component(
        modules = {
                AppModule.class,
        }
)
@AppScope
public interface AppComponent {
    void inject(Application app);
}