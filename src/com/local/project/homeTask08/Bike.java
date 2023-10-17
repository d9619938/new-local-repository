package com.local.project.homeTask08;

public class Bike extends Vehicle {
    private int numberOfWheels = 2;
    private String type = "городской";


    public Bike(String number, int speed) {
        super(number, speed);
    }

    public Bike(String number, int speed, int numberOfWheels) {
        super(number, speed);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels(){
        return numberOfWheels;
    }
    public String getType() {
        return type;
    }
}

