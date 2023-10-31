package com.local.project.exam01;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

Card gm01 = new Card(CardType.DAY, LocalDate.of(2023, 11, 29),
        new Visitor("Иван", "Иванов", LocalDate.of(1946,10,30)));
        System.out.println(gm01);
        Card gm02 = new Card(CardType.ONE_TIME, LocalDate.now().plusDays(1),
                new Visitor("Иван", "Иванов", LocalDate.of(1987, 2, 16)));
        System.out.println(gm02);
        Card gm03 = new Card(CardType.FULL, LocalDate.now().plusDays(1),
                new Visitor("Иван", "Иванов", LocalDate.of(1987, 2, 16)));
        System.out.println(gm03);

        Fitnes fitnes = new Fitnes();
        fitnes.enterTheZone(fitnes.poolZone, gm01);
        fitnes.enterTheZone(fitnes.groupClassesZone, gm02);
        fitnes.enterTheZone(fitnes.groupClassesZone, gm03);



    }
}
