package com.builder;

import java.util.ArrayList;

public class ResourceSet {
    public int estimatedTotal;
    public ArrayList<Resource> resources;

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

}
