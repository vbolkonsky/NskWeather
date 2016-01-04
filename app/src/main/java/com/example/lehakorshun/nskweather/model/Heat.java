package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Heat implements Serializable{

    @Attribute(name = "max")
    private int max;

    @Attribute(name = "min")
    private int min;

    public int getMax() {
        return Math.max(max, min);
    }

    public int getMin() {
        return Math.min(min, max);
    }

}
