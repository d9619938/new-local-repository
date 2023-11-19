package com.local.project.lesson25;

public class Rate {
    private int id;
    private RateType rateType;

    public Rate(int id, RateType rateType) {
        this.id = id;
        this.rateType = rateType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public enum RateType{
        FULL, LITE
    }
}
