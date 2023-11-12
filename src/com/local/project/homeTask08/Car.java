package com.local.project.homeTask08;

import java.awt.*;

public class Car extends Vehicle implements Painting{
    private String color = "�����";

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
        System.out.println("������ �����������");
    }

    @Override
    public void setDefaultColor() {
        color = "�����";
    }

    @Override
    public void chengeColor(String color) {
        this.color =  color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                '}';
    }
}
