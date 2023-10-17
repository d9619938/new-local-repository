package com.local.project.homeTask08;

import java.util.Arrays;

public class RepairShop {

    private Vehicle[] vehicles;
    private String[] colors = {"красный", "желтый", "жёлтый", "оранжевый", "чёрный"};

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void addToVehicles(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("vehicle not null");
        }
        if (vehicles == null) vehicles = new Vehicle[3];
        int indexCount = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) indexCount++;
        }
        if (indexCount == vehicles.length) {
            Vehicle[] vehicleClon = Arrays.copyOf(vehicles, vehicles.length + 3);
            vehicles = vehicleClon;
        }
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == vehicle) return;
            else if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                return;
            }
        }

    }

    public void repairAll() {
/*        for (Vehicle vehicle : vehicles) {
            if (vehicle == null) return;
            vehicle.repair();
                                 //            if (vehicle instanceof Train) {   // проверку и
                                 //                Train t = (Train) vehicle;    // приведение можно
                                 //                t.changeClimateControl();     // записать короче
                                 //            }
            if (vehicle instanceof Car car) {
                car.setColor(colors[(int) (Math.random() * colors.length)]);
            }
        }*/
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) return;
            vehicles[i].repair();
            if(vehicles[i] instanceof Car car) {
                car.setColor(colors[(int) (Math.random() * colors.length)]);
            }
            vehicles[i] = null;
        }

    }

}
