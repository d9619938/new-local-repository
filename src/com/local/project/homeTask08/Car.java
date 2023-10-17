package com.local.project.homeTask08;

public class Car extends Vehicle{
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
}
