package com.local.project.homeTask10.task.animals;

import java.util.Arrays;

abstract public class Animal {
    private String name;
    private double age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
    public static Wolf giveBirthToAWolf () {
        return new Wolf(new String[]{"суши", "фуагрa"}, "белый");
//        return new Wolf(new String[3], null);  /*если заполнить свойства Wolf null, equals тоже сработает верно*/
    }
    public static void check(Wolf one, Wolf two) {
        System.out.printf("имя первого волка - %s, имя второго волка - %s\n", one.getName(), two.getName());
        System.out.printf("возраст первого волка - %.2f, возраст второго волка - %.2f\n", one.getAge(), two.getAge());
        System.out.printf("сила первого волка - %d, сила второго волка - %d\n", one.getStrength(), two.getStrength());
        System.out.printf("еда первого волка - %s, еда второго волка - %s\n", Arrays.toString(one.getLikeToEat()),
                                                                                Arrays.toString(two.getLikeToEat()));
        System.out.printf("цвет первого волка - %s, цвет второго волка - %s\n", one.getColor(), two.getColor());
        System.out.printf("равны ли два волка? - %B\n", one.equals(two));
        System.out.println();
    }
    public static void addMeanings (Wolf one, Wolf two) {
        one.setAge(15.00);
        one.setName("Иван");
        one.setStrength(74);
        two.setAge(15.00);
        two.setName("Иван");
        two.setStrength(74);
    }
}
