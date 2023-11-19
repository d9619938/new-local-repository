package com.local.project.lesson22.цепочкаќб€зательсв;

public class Main {
    public static void main(String[] args) {
        Action action01 = new Eat();
        Action action02 = new Drink();
        Action action03 = new Play();

        // выстраиваютс€ в цепочку
        action01.nextAction(action02);
        action02.nextAction(action03);

        Animal animal = new Animal();
        animal.doAction(action01);
    }
}
