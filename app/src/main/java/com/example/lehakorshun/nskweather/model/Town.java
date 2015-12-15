package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "TOWN", strict = false)
public class Town {

    @Attribute
    String index;

    @ElementList(name = "FORECAST", inline = true ,required = true)
    List<Forecast> forecast;

}
