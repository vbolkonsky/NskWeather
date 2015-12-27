package com.example.lehakorshun.nskweather.component;


import com.example.lehakorshun.nskweather.modules.TownModule;
import com.example.lehakorshun.nskweather.model.Town;

import dagger.Component;

@Component(modules = { TownModule.class })
public interface TownComponent {
    Town provideTown();
}
