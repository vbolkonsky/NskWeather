package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "TOWN", strict = false)
public class Town implements Serializable {

    @Attribute
    String index;

    @ElementList(name = "FORECAST", inline = true ,required = true)
    List<Forecast> forecasts;

    public List<Forecast> getForecasts() {
        return forecasts;
    }
}
