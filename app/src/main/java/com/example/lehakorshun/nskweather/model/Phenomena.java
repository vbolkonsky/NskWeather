package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

public class Phenomena {

    @Attribute(name = "cloudiness")
    private long cloudiness;

    @Attribute(name = "precipitation")
    private long precipitation;

    @Attribute(name = "rpower")
    private long rpower;

    @Attribute(name = "spower")
    private long spower;

    public long getCloudiness() {
        return cloudiness;
    }

    public long getPrecipitation() {
        return precipitation;
    }

    public long getRpower() {
        return rpower;
    }

    public long getSpower() {
        return spower;
    }
}
