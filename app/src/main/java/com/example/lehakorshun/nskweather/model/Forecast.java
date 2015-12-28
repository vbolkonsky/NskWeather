package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "FORECAST", strict = false)
public class Forecast {

    @Attribute(name = "day")
    private long day;

    @Attribute(name = "month")
    private long month;

    @Attribute(name = "year")
    private long year;

    @Attribute(name = "hour")
    private long hour;

    @Attribute(name = "weekday")
    private long weekday;

    public long getDay() {
        return day;
    }

    public long getMonth() {
        return month;
    }

    public long getYear() {
        return year;
    }

    public long getHour() {
        return hour;
    }

    public long getWeekday() {
        return weekday;
    }

    @Element(name = "PHENOMENA")
    private Phenomena phenomena;

    @Element(name = "PRESSURE")
    private Pressure pressure;

    @Element(name = "TEMPERATURE")
    private Temperature temperature;

    @Element(name = "WIND")
    private Wind wind;

    @Element(name = "RELWET")
    private Relwet relwet;

    @Element(name = "HEAT")
    private Heat heat;

    public Phenomena getPhenomena() {
        return phenomena;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public Relwet getRelwet() {
        return relwet;
    }

    public Heat getHeat() {
        return heat;
    }
}
