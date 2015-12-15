package com.example.lehakorshun.nskweather.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "MMWEATHER", strict = false)
public class Mmweather {

    @Element(name = "REPORT")
    Report report;

}
