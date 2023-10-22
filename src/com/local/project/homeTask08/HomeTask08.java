package com.local.project.homeTask08;

import java.util.Arrays;

public class HomeTask08 {
    public static void main(String[] args) {

        Car car = new Car("1");
        Train train = new Train("1", 200, 5, true);
        Bike bike = new Bike("1", 30, 2);

        Scooter scooter01 = new Scooter("1", 30, false);
        System.out.println("1) количество колес у самоката - " + scooter01.getNumberOfWheels());
        System.out.println("2) макс. скорость самоката - " + scooter01.getMaxSpeed());
        System.out.println("3) тип самоката - " + scooter01.getType());
        Scooter scooter02 = new Scooter("2", 130, true);
        Scooter scooter03 = new Scooter("3", 60, false);
        Scooter scooter04 = new Scooter("4", 50, true);


        RepairShop repairShop = new RepairShop();
        repairShop.addToVehicles(car);
        repairShop.addToVehicles(train);
        repairShop.addToVehicles(bike);
        repairShop.addToVehicles(scooter01);
        repairShop.addToVehicles(scooter02);
        repairShop.addToVehicles(scooter03);
        repairShop.addToVehicles(scooter04);
        scooter02.setDefaultColor();
        System.out.println(scooter02.getColor());
        scooter02.chengeColor("серобуромалиновый");
        System.out.println(scooter02.getColor());

        System.out.println("4) Массив Vehicle до работы метода repairAll - " + Arrays.toString(repairShop.getVehicles()));
        System.out.println("5) Цвет машины до работы метода repairAll - " + car.getColor());
        repairShop.repairAll();
        System.out.println("6) Цвет машины после работы метода repairAll - " + car.getColor());
        System.out.println("7) Массив Vehicle после работы метода repairAll - "+ Arrays.toString(repairShop.getVehicles()));
    }
}
