package com.local.project.lesson20;

public class SomeClass {

    public void someVoid01(){ // класс верхнего уровн€

        Runnable runnable01 = () -> System.out.println("Hello"); // анонимный класс
        Runnable runnable02 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
    }

    public void someVoid02(){
        class SubClass01 {} // класс вложенный в метод - Ћќ јЋ№Ќџ…  Ћј——
    }
    public class SubClass02 {} // внутренний класс
    public static class SubClass03 {} // вложенный класс
}
