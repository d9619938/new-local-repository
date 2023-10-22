package com.local.project.homeTask08;

public class Train extends Vehicle {
    private int carCount;
    private boolean isClimateControl;

    public Train(String number, int carCount, boolean isClimateControl) {
        super(number);
        this.carCount = carCount;
        this.isClimateControl = isClimateControl;
    }

    public Train(String number, int speed, int carCount, boolean isClimateControl) {
        super(number, speed);
        this.carCount = carCount;
        this.isClimateControl = isClimateControl;
    }

    public int getCarCount() {
        return carCount;
    }
    public void setCarCount(int count) {
        carCount = count;
    }

    public boolean isClimateControl() {
        return isClimateControl;
    }

    public void changeClimateControl() {
        this.isClimateControl = !isClimateControl;
    }
    // переопределение метода родителя
    @Override // аннотация, доступна только на этапе компиляции
    public void repair() {
        if (carCount < 7 && carCount > 0) {
            if (wearLevel >= 2) wearLevel -=2;
            else wearLevel--;
        } else {
//            if (wearLevel > 0) {
//                wearLevel--;
            this.repair();
        }
    }
    public void stop() {
        System.out.println("Поезд остановлен");
    }
}