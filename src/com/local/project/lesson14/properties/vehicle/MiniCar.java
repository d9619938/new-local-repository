package com.local.project.lesson14.properties.vehicle;

public class MiniCar extends Car implements Runnable{
    public MiniCar(Color color, String number) {
        super(color, number);
    }

    @Override
    public void run() {
        incLevelOfWare(1);
    }
}