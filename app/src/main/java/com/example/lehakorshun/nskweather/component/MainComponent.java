package com.example.lehakorshun.nskweather.component;

import com.example.lehakorshun.nskweather.scopes.ActivityScope;
import com.example.lehakorshun.nskweather.MainActivity;
import com.example.lehakorshun.nskweather.modules.MainModule;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
