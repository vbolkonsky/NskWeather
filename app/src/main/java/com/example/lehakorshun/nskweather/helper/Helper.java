package com.example.lehakorshun.nskweather.helper;

import com.example.lehakorshun.nskweather.R;

public class Helper {

    private static final String NORTH_DIRECTION = "North";
    private static final String NORTHEAST_DIRECTION = "Northeast";
    private static final String EAST_DIRECTION = "east";
    private static final String SOUTHEAST_DIRECTION = "Southeast";
    private static final String SOUTH_DIRECTION = "South";
    private static final String SOUTHWEST_DIRECTION = "Southwest";
    private static final String WEST_DIRECTION = "West";
    private static final String NORTHWEST_DIRECTION = "Northwest";

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

    public static String getWindDirection(int direction) {
        switch (direction) {
            case 0:
                return NORTH_DIRECTION;
            case 1:
                return NORTHEAST_DIRECTION;
            case 2:
                return EAST_DIRECTION;
            case 3:
                return SOUTHEAST_DIRECTION;
            case 4:
                return SOUTH_DIRECTION;
            case 5:
                return SOUTHWEST_DIRECTION;
            case 6:
                return WEST_DIRECTION;
            case 7:
                return NORTHWEST_DIRECTION;
            default:
                return NORTH_DIRECTION;
        }
    }
}
