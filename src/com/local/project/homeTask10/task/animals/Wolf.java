package com.local.project.homeTask10.task.animals;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal {
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    protected String getColor() {
        return this.color;
    }
    protected String[] getLikeToEat () {
        return likeToEat;
    }

//    ���������� Wolf ��������� ������� �� ������ equals, ���� ����� �������� ���� �� �������.
//    ������ �� ������� �������� �� ��������� ��� �������� ������ Wolf, � ��� ����� ������������� �� ������������ �������.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wolf wolf)) return false;
        if (getName() == null && wolf.getName() != null) return false; // ���������� �� NPE
        if (getName() == null && wolf.getName() == null) // ���� ��� String null, ��������� ��� ��� ���
            return Arrays.equals(likeToEat, wolf.likeToEat) && Objects.equals(color, wolf.color)
                    && getStrength() == wolf.getStrength() && getAge() == wolf.getAge();
        else return Arrays.equals(likeToEat, wolf.likeToEat) && Objects.equals(color, wolf.color) //
                && getStrength() == wolf.getStrength() && getAge() == wolf.getAge() && getName().equals(wolf.getName());
    }

    public static void main(String[] args) {

        Animal[] animals = new Animal[]{giveBirthToAWolf(), giveBirthToAWolf()}; // ������ ���� Animal � ��������� Wolf
        Wolf wolfOne = (Wolf) animals[0]; // ������� � ���� Wolf, ����� �������� �� ���������� Wolf
        Wolf wolfTwo = (Wolf) animals[1];
        check(wolfOne, wolfTwo);
        addMeanings(wolfOne, wolfTwo);
        check(wolfOne, wolfTwo);
        wolfOne.setName(null);
        check(wolfOne, wolfTwo); // �������� NPE
        wolfOne.setName("����");
        check(wolfOne, wolfTwo);
    }
}
