package com.wealthPark.restful.format.request;

public class PurchaserParams {
    String name;

    public PurchaserParams() {
    }

    public PurchaserParams(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
