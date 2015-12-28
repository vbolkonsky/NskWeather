package com.example.lehakorshun.nskweather.helper;

import com.example.lehakorshun.nskweather.R;

public class Helper {

    public static int getImage(int cloudiness) {
        switch (cloudiness) {
            case 0:
                return R.drawable.art_clear;
            case 1:
                return R.drawable.art_light_clouds;
            case 2:
                return R.drawable.art_fog;
            default:
                return R.drawable.art_clouds;
        }
    }
}
