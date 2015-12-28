package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Relwet implements Serializable{

    @Attribute(name = "max")
    private long max;

    @Attribute(name = "min")
    private long min;

    public long getMax() {
        return max;
    }

    public long getMin() {
        return min;
    }

}
