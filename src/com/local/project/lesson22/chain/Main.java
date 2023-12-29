package com.local.project.lesson22.chain;
public class Main {
    public static void main(String[] args) {
        Action action01 = new Eat();
        Action action02 = new Drink();
        Action action03 = new Play();

        // ������������� � �������
        action01.nextAction(action02);
        action02.nextAction(action03);

        Animal animal = new Animal();
        animal.doAction(action01);
    }
}
