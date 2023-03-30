package com.builder;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource {
    public String __type;
    public String name;
    public Point point;
    @JsonProperty("Address")
    public Address address;
    @JsonProperty("PhoneNumber")
    public String phoneNumber;
    @JsonProperty("Website")
    public String website;
    public String entityType;
    public ArrayList<GeocodePoint> geocodePoints;
}
