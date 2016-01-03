package com.example.lehakorshun.nskweather.component;

import com.example.lehakorshun.nskweather.MainActivity;
import com.example.lehakorshun.nskweather.modules.MainModule;
import com.example.lehakorshun.nskweather.scopes.ActivityScope;

import dagger.Component;

@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class)
@ActivityScope
public interface MainComponent {
    void inject(MainActivity activity);
}
