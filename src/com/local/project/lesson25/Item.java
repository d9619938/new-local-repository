package com.local.project.lesson25;

import java.io.Serializable;

public class Item implements Serializable {
    private long id;
    private String name;
    private double price;
    private Trader trader;

    public Item(long id, String name, double price, Trader trader) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.trader = trader;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }
}
