package com.rajan.demo.dto;


import lombok.Data;

// @Data can be used tor remove getter and setter
public class BatteryDto {
    private String name;
    private String postcode;
    private int wattCapacity;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public int getWattCapacity() {
        return wattCapacity;
    }


    public void setWattCapacity(int wattCapacity) {
        this.wattCapacity = wattCapacity;
    }

}

