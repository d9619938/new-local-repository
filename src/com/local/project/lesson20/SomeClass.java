package com.local.project.lesson20;

public class SomeClass {

    public void someVoid01(){ // ����� �������� ������

        Runnable runnable01 = () -> System.out.println("Hello"); // ��������� �����
        Runnable runnable02 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
    }

    public void someVoid02(){
        class SubClass01 {} // ����� ��������� � ����� - ��������� �����
    }
    public class SubClass02 {} // ���������� �����
    public static class SubClass03 {} // ��������� �����
}
