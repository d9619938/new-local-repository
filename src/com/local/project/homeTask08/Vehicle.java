package com.local.project.homeTask08;

public abstract class Vehicle {
    protected String number;
    protected int wearLevel;
    protected int maxSpeed = 120;

    public Vehicle (String number){
        this.number = number;
    }
    public Vehicle (String number, int speed){
        this(number);
        setMaxSpeed(speed);
    }

    public String getNumber() {
        return number;
    }
    public int getWearLevel() {
        return wearLevel;
    }
    public void plusWearLevel(int number) {
        if (number < 0) return;
        wearLevel += number;
    }
    public void repair() {
        if (wearLevel > 0)
            wearLevel--;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    public abstract void stop();
}

