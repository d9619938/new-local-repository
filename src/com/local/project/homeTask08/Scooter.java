package com.local.project.homeTask08;

public class Scooter extends Bike {

    // в классе в любом случае остается доступным поле number и maxSpeed,
    // но в задании не говорится, что мы не можем менять их в main вне конструктора

    private boolean isElectric;

    public Scooter(String number, int speed, boolean isElectric) {
        super(number, speed);
        this.isElectric = isElectric;
    }

    @Override
    public void repair() {
        if (this.isElectric) {
            if (wearLevel >= 2) wearLevel -= 2;
            else wearLevel--;
        } else {
            if (wearLevel >= 3) wearLevel -= 3;
            else if (wearLevel == 2) wearLevel -= 2;
            else wearLevel--;
        }
    }
}
