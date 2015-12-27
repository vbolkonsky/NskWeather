package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Report {

    @Element(name = "TOWN")
    private Town town;

    public Town getTown() {
        return town;
    }
}
