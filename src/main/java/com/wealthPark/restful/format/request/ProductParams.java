package com.wealthPark.restful.format.request;

public class ProductParams {
    String name;

    public ProductParams() {
    }

    public ProductParams(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
