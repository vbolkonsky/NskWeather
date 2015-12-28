package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;

public class Heat {

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
