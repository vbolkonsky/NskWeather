package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Wind implements Serializable{

    @Attribute(name = "max")
    private long max;

    @Attribute(name = "min")
    private long min;

    @Attribute(name = "direction")
    private long direction;

    public long getMax() {
        return max;
    }

    public long getMin() {
        return min;
    }

    public long getDirection() {
        return direction;
    }
}
