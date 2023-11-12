package com.local.project.lesson17.task;

import com.local.project.homeTask08.*;

import java.util.*;

public class HomeTask02 {
    public static void main(String[] args) {
        HomeTask02 homeTask02 = new HomeTask02();
        homeTask02.mission01();
        System.out.println();

        homeTask02.mission02();
        System.out.println();

        homeTask02.mission03();
    }

    private static <T extends Vehicle> ArrayList<T> vehiclesInNeedOfRepair(Map<String, ? super T> map, int wearLevel) {
        //        Задание №1.
//        Написать метод, принимающий на вход мапу и уровень износа. Ключи мапы - номера транспортных средств,
//        значения - любые транспортные средства. Метод возвращает список транспортных средств,
//        уровень износа которых больше переданного в метод.
        ArrayList<T> vehiclesInNeedOfRepairs = new ArrayList<>();
        for (Map.Entry<String, ? super T> entry : map.entrySet()) {
            Vehicle vehicle = (Vehicle) entry.getValue();
            if (vehicle.getWearLevel() > wearLevel) {
                vehiclesInNeedOfRepairs.add((T) vehicle);
            }
        }
        return vehiclesInNeedOfRepairs;
    }

    private static <T extends Vehicle & Painting> void repaintList(ArrayList<? super T> readyForPainting,
                                                                   Map<String, ArrayList<Painting>> map) {
        //    Написать метод, принимающий на вход список перекрашиваемых объектов и мапу, где ключи - цвета,
//    а значения - списки покрашенных в данный цвет объектов. В методе необходимо наполнить мапу элементами списка.

        for (Object obj : readyForPainting) {
            ArrayList<Painting> repaintList = new ArrayList<>();
            if (obj instanceof Car car) {
                String color = "black";
                car.chengeColor(color);
                if (map.containsKey(color)){
                    ArrayList<Painting> duplicate =  map.get(color);
                    duplicate.add(car);
                    map.put(car.getColor(), duplicate);
                } else {
                    repaintList.add(car);
                    map.put(car.getColor(), repaintList);
                }
            } else if (obj instanceof Scooter scooter) {
                String color = "rose";
                scooter.chengeColor(color);
                if (map.containsKey(color)) {
                    ArrayList<Painting> duplicate = map.get(color);
                    duplicate.add(scooter);
                    map.put(scooter.getColor(), duplicate);
                } else {
                    repaintList.add(scooter);
                    map.put(scooter.getColor(), repaintList);
                }
            }
        }
    }

    private static <T extends Vehicle> Map<String, T> repairMap (ArrayList<? super T> list) {
        //Написать метод, принимающий на вход список ремонтируемых транспортных средств и возвращающий мапу,
        // где ключи - номера транспортных средств, а значения - любые транспортные средства.
        // В методе необходимо вызвать метод repair транспортного средства,
        // после чего добавить транспортное средство в результирующую мапу.
        Map<String, T> repairMap = new HashMap<>();
        for (Object obj : list){
            Objects.requireNonNull(obj, "list не может содержать null ссылки");
            if (obj instanceof Vehicle vehicle){
                vehicle.repair();
                repairMap.put(vehicle.getNumber(), (T)vehicle);
            }
        }
        return repairMap;
    }



    private void mission01() {

        Bike bike01 = new Bike("130", 25);
        Bike bike02 = new Bike("99", 25);
        Bike bike03 = new Bike("101", 25);
        Car car01 = new Car("102");
        Car car02 = new Car("98");
        Car car03 = new Car("97");

        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put(bike01.getNumber(), bike01);
        vehicleMap.put(bike02.getNumber(), bike02);
        vehicleMap.put(bike03.getNumber(), bike03);
        vehicleMap.put(car01.getNumber(), car01);
        vehicleMap.put(car02.getNumber(), car02);
        vehicleMap.put(car03.getNumber(), car03);

        bike01.plusWearLevel(Integer.parseInt(bike01.getNumber()));
        bike02.plusWearLevel(Integer.parseInt(bike02.getNumber()));
        bike03.plusWearLevel(Integer.parseInt(bike03.getNumber()));
        car01.plusWearLevel(Integer.parseInt(car01.getNumber()));
        car02.plusWearLevel(Integer.parseInt(car02.getNumber()));
        car03.plusWearLevel(Integer.parseInt(car03.getNumber()));

        System.out.printf("Задание №1\nдо работы метода vehiclesInNeedOfRepair():\n%s\n", vehicleMap);
        System.out.println();
        System.out.printf("список после работы метода vehiclesInNeedOfRepair():\n%s\n", vehiclesInNeedOfRepair(vehicleMap, 100));
    }
    private void mission02() {

        ArrayList <Vehicle> readyForPainting = new ArrayList<>();
        Scooter scooter01 = new Scooter("1", 54, true);
        Scooter scooter02 = new Scooter("2", 80, false);
        Scooter scooter03 = new Scooter("3", 30, true);
        scooter01.setDefaultColor();
        scooter02.setColor("yellow");
        scooter03.setColor("pink");

        Car car01 = new Car("1");
        Car car02 = new Car("2");
        Car car03 = new Car("3");
        car01.setColor("green");
        car02.setColor("dark grey");
        car03.setColor("blue");

        Bike bike01 = new Bike("1", 130);
        Bike bike02 = new Bike("2", 100);
        Bike bike03 = new Bike("3", 360);

        readyForPainting.add(scooter01);
        readyForPainting.add(scooter02);
        readyForPainting.add(scooter03);
        readyForPainting.add(car01);
        readyForPainting.add(car02);
        readyForPainting.add(car03);
        readyForPainting.add(bike01);
        readyForPainting.add(bike02);
        readyForPainting.add(bike03);
        System.out.printf("Задание №2\nдо работы метода repaintList():\n %s\n",readyForPainting);
        Map<String, ArrayList<Painting>> map = new HashMap<>();


        System.out.println();

        repaintList(readyForPainting, map);
        System.out.printf("После работы метода repaintList():\n %s\n", map);
    }
    private void mission03() {
        Bike bike01 = new Bike("130", 25);
        Bike bike02 = new Bike("99", 25);
        Bike bike03 = new Bike("101", 25);
        Car car01 = new Car("102");
        Car car02 = new Car("98");
        Car car03 = new Car("97");

        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put(bike01.getNumber(), bike01);
        vehicleMap.put(bike02.getNumber(), bike02);
        vehicleMap.put(bike03.getNumber(), bike03);
        vehicleMap.put(car01.getNumber(), car01);
        vehicleMap.put(car02.getNumber(), car02);
        vehicleMap.put(car03.getNumber(), car03);

        bike01.plusWearLevel(Integer.parseInt(bike01.getNumber()));
        bike02.plusWearLevel(Integer.parseInt(bike02.getNumber()));
        bike03.plusWearLevel(Integer.parseInt(bike03.getNumber()));
        car01.plusWearLevel(Integer.parseInt(car01.getNumber()));
        car02.plusWearLevel(Integer.parseInt(car02.getNumber()));
        car03.plusWearLevel(Integer.parseInt(car03.getNumber()));

        ArrayList<Vehicle> repairList = vehiclesInNeedOfRepair(vehicleMap, 100);
        System.out.println("Задание №3");
        for (Vehicle vehicle : repairList){
            System.out.printf("До работы метода repairMap(): %s %d\n", vehicle, vehicle.getWearLevel());
        }
        System.out.println();
        Map<String, Vehicle> repairMap = repairMap(repairList);
        System.out.printf("работает метод repairMap(): %s\n", repairMap );

        System.out.println();
        Set<Map.Entry<String, Vehicle>> repairMapEntry = repairMap.entrySet();
        for(Map.Entry<String, Vehicle> entry : repairMapEntry) {
            System.out.printf("После работы метода repairMap(): %s %d\n", entry.getValue(), entry.getValue().getWearLevel());
        }

    }
}
