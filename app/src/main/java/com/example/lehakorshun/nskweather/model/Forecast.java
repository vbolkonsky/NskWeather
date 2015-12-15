package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "FORECAST", strict = false)
public class Forecast {

    @Attribute(name = "day")
    private long day;

    @Attribute(name = "month")
    private long month;

    @Attribute(name = "year")
    private long year;



}
