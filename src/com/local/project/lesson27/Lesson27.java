package com.local.project.lesson27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson27 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");

        ThreadTask threadTask01 = new ThreadTask(stringList);
        threadTask01.setName("ThreadTask 01");
        System.out.println(threadTask01.getState()); // ��������� ������
        threadTask01.setPriority(10); // ����� ����������������, �� ���������� �� 100% ������

        ThreadTask threadTask02 = new ThreadTask(stringList);
        threadTask02.setName("ThreadTask 02");
        threadTask02.setPriority(10); // ����� ����������������, �� ���������� �� 100% ������

//        ������ ����� �������, �� ���������� �� ����� ����������� � ��������� ������!!!
        threadTask01.printList(); // �� ����� �������� � ������ threadTask
        threadTask01.run(); // �� ����� �������� � ������ threadTask
//        threadTask.start(); // ����� ����� � ������ � ����������� ������� �������� ���, ����� �����

        threadTask01.start();
        threadTask02.start();


        System.out.println("main");

        RunnableTask runnableTask = new RunnableTask("task");
        Thread threadWithRunnable = new Thread(runnableTask);
        System.out.println(threadWithRunnable.getState());
        threadWithRunnable.start();


        //�������� ������ ����� ������
        // �������� ������ void run(); �� �� ����� ������ ��������� ��� ����������
//        Thread threadWithLambda = new Thread(() -> {
//            // ������ ������
//            while (true){
//            System.out.println(Thread.currentThread().getName());
//        }
//        });

        // ������� ����� ����� �������� �� ��� ���, ���� �������� ���� �� ���� �������� �����, ���� �� ����������� ����������
        // ����� ������ �� ������ ��������, ���� ��� ������ ������ ����������
//        threadWithLambda.setName("DEAMON");
//        threadWithLambda.setDaemon(true); // ����� setDemon - ����������� ����� � ������� �����. ���������� ����� �� ������ start();
//        threadWithLambda.start();
       
        List<Double> doubles = new ArrayList<>();
        Thread addTODoubles = new Thread(()->{
//            while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
            doubles.add(Math.random());
//            }
        });
        addTODoubles.setName("addDoubles");
        addTODoubles.start();
        try{
            //  addTODoubles.join();  // main ����, ���� addDoub �������� ������
            addTODoubles.join(1000); /// main ����, ���� addDoubles �������� ������ 1000 �����������
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(doubles);
        
        System.out.println("main");


        // Thread interrupted - false
        // .isInterrupted() -> false
        // .interrupt() -> interrupted -> true
        // .isInterrupted() -> true
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                // ���������� ������
                try {
                    Thread.sleep((1000));
                } catch (InterruptedException e) {  // ������ �������� interrupted �� false
                    Thread.currentThread().interrupt(); // ����� �������� ����� ����� ����������� ������� interrupt!!!!, ������ �� true
                }
            }
        });

        thread.start();
        thread.interrupt(); // ������ �������� �������� isInterrupted() �� true

    }
}
