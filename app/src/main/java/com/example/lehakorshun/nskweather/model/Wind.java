package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Wind implements Serializable{

    @Attribute(name = "max")
    private int max;

    @Attribute(name = "min")
    private int min;

    @Attribute(name = "direction")
    private int direction;

    public int getMax() {
        return Math.max(max, min);
    }

    public int getMin() {
        return Math.min(min, max);
    }

    public int getDirection() {
        return direction;
    }
}
