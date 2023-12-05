package com.local.project.lesson27;

import java.util.List;

public class ThreadTask extends Thread{
    private List<String> stringList;

    public ThreadTask(List<String> stringList){
        this.stringList = stringList;
        System.out.println("Constructor " + Thread.currentThread().getName());
        this.setPriority(7);  // ����� ����� ���������� ���������
       // this.setName("TreadTask"); // ����� ������ ��� ������

    }

    public void printList() {
        stringList.forEach(System.out::println);
//        stringList.forEach(str -> System.out.println(str + " " + Thread.currentThread().getName()));  // ���� �����
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        printList();
    }

}
