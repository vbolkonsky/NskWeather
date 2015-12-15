package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

@Element(name = "TOWN")
public class Town {

    @Attribute
    String index;

    @ElementList(inline = true ,required = true)
    List<Forecast> forecast;

}
