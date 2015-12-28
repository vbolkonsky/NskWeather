package com.example.lehakorshun.nskweather.component;

import com.example.lehakorshun.nskweather.App;
import com.example.lehakorshun.nskweather.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
        }
)
public interface AppComponent {
    void inject(App app);

}