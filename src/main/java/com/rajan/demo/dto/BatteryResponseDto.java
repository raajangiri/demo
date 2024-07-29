package com.rajan.demo.dto;



import lombok.Data;

import java.util.List;

// @Data can be used to to remove getter and detter
public class BatteryResponseDto {
    private List<String> names;
    private double totalWattCapacity;
    private double averageWattCapacity;

    public List<String> getNames() {
        return names;
    }


    public void setNames(List<String> names) {
        this.names = names;
    }


    public double getTotalWattCapacity() {
        return totalWattCapacity;
    }

    public void setTotalWattCapacity(double totalWattCapacity) {
        this.totalWattCapacity = totalWattCapacity;
    }


    public double getAverageWattCapacity() {
        return averageWattCapacity;
    }

    public void setAverageWattCapacity(double averageWattCapacity) {
        this.averageWattCapacity = averageWattCapacity;
    }
}

