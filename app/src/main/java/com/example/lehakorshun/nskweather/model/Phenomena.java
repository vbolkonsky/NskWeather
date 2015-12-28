package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Phenomena implements Serializable{

    @Attribute(name = "cloudiness")
    private int cloudiness;

    @Attribute(name = "precipitation")
    private int precipitation;

    @Attribute(name = "rpower")
    private int rpower;

    @Attribute(name = "spower")
    private int spower;

    public int getCloudiness() {
        return cloudiness;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public int getRpower() {
        return rpower;
    }

    public int getSpower() {
        return spower;
    }
}
