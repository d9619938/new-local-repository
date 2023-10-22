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
        return new Wolf(new String[]{"����", "�����a"}, "�����");
//        return new Wolf(new String[3], null);  /*���� ��������� �������� Wolf null, equals ���� ��������� �����*/
    }
    public static void check(Wolf one, Wolf two) {
        System.out.printf("��� ������� ����� - %s, ��� ������� ����� - %s\n", one.getName(), two.getName());
        System.out.printf("������� ������� ����� - %.2f, ������� ������� ����� - %.2f\n", one.getAge(), two.getAge());
        System.out.printf("���� ������� ����� - %d, ���� ������� ����� - %d\n", one.getStrength(), two.getStrength());
        System.out.printf("��� ������� ����� - %s, ��� ������� ����� - %s\n", Arrays.toString(one.getLikeToEat()),
                                                                                Arrays.toString(two.getLikeToEat()));
        System.out.printf("���� ������� ����� - %s, ���� ������� ����� - %s\n", one.getColor(), two.getColor());
        System.out.printf("����� �� ��� �����? - %B\n", one.equals(two));
        System.out.println();
    }
    public static void addMeanings (Wolf one, Wolf two) {
        one.setAge(15.00);
        one.setName("����");
        one.setStrength(74);
        two.setAge(15.00);
        two.setName("����");
        two.setStrength(74);
    }
}
