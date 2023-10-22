package com.local.project.homeTask08;

import java.awt.*;

public class Car extends Vehicle implements Painting{
    private String color = "белый";

    public Car(String number) {
        super(number, 240);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void repair() {
        super.repair();
    }
    public void stop() {
        System.out.println("Машина остановлена");
    }

    @Override
    public void setDefaultColor() {
        color = "белый";
    }

    @Override
    public void chengeColor(String color) {
        this.color =  color;
    }
}
