package com.local.project.lesson11.homeTask11;

import java.util.Arrays;

public class HomeTask11 {
    public static void main(String[] args) {
        System.out.println("           ********* ������ ������������ Enum *****         ");

        System.out.println(Arrays.toString(Planet.values()));

        System.out.println("           ********* ������ ������ � ��������� ������� *****         ");

        for (Enum<Planet> p : Planet.values() ) {
            System.out.printf("%d) %s\n",p.ordinal(), p);
        }
        System.out.println();
        System.out.println(Planet.MERCURY.getMass());
    }
}
