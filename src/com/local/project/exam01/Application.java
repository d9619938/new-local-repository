package com.local.project.exam01;

import java.util.ArrayList;

public class Application {
        public static void main(String[] args) {

            Fitness fitness = new Fitness();
            fitness.printInfoAllCard();  // выводим дефолтные значени€, не заполн€ю, они и так есть - "null"

                ArrayList<Card> cards = new ArrayList<>();
            // —оздаем абонементы. ћетод generateCard специально поднастроил, чтобы (почти) не выбрасывал ошибки ввода.
            // ≈сли сознательно/несознательно создавать руками экземпл€р Card, то ошибки ввода отловит.
                for (int i = 0; i < 80; i++) {
                                cards.add(Helper.generateCard());
                                System.out.println(cards.get(i));
                }

            for (Card card : cards) {  // проходим через турникет в зоны клуба
                fitness.enterTheZone(fitness.poolZone, card);
                fitness.enterTheZone(fitness.gymZone, card);
                fitness.enterTheZone(fitness.groupClassesZone, card);
            }

            fitness.printInfoAllCard(); // провер€ем, кто находитс€ в клубе в данный момент
            fitness.leaveTheZone(fitness.poolZone, cards.get(1)); // посетитель выходит из зоны
            fitness.printInfoAllCard(); // провер€ем, кто находитс€ в клубе в данный момент

        }
}
