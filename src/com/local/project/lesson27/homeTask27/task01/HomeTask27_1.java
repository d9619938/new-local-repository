package com.local.project.lesson27.homeTask27.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeTask27_1 {

    /*## ������� �1
1. ���� 4 ����� � ��������� �����������.
2. ������ � ������ ����� ��������� ���: ���� � �����::���������::���������� � �������
3. ��������� - ������������� �������� �� 1 �� 10, ��� 10 - ��������� ���������.
4. ������� � ������� ���������� � �������� � ����������� 7 � ����.
5. ������� � ������� ���������� � ���, ������� ��������� � ����������� 7 � ���� ���������� � �����.
6. ������ ���� ������ �������������� � ��������� ������.*/
    public static void main(String[] args){
        InfoFile thread01 = new InfoFile("thread01","D:\\JAVA\\test\\Task27\\infofile01.txt");
        InfoFile thread02 = new InfoFile("thread02", "D:\\JAVA\\test\\Task27\\infofile02.txt");
        InfoFile thread03 = new InfoFile("thread03", "D:\\JAVA\\test\\Task27\\infofile03.txt");
        InfoFile thread04 = new InfoFile("thread04", "D:\\JAVA\\test\\Task27\\infofile04.txt");

        thread01.start();
        try {
            thread01.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread02.start();
        try {
            thread02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread03.start();
        try {
            thread03.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread04.start();
        try {
            thread04.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

   static class InfoFile extends Thread {
        private List<String[]> info;
        private String filename;

        public InfoFile(String name, String filename) {
            if (name == null) throw new IllegalArgumentException("name not null");
            this.setName(name);
            this.filename = filename;
        }
        public void run(){
                System.out.println("�������� ����� " + Thread.currentThread().getName());
                parseFile();
                System.out.println();
                outputOfEventsGreaterThanSeven();
                System.out.println();
                displayingTheNumberOfEventsGreaterThanSeven();
                System.out.println("����� " + Thread.currentThread().getName() + " �������� ���� ������");
                System.out.println();
        }

        private void parseFile(){
            info = new ArrayList<>();
            String line = null;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                while ((line = reader.readLine()) != null){
                    String[] parseLine = line.split("::");
                    info.add(parseLine);
                }
                } catch (IOException e){
                System.out.println(e.getMessage());
                System.out.println("������ ������ �����");
            }
        }
        private void outputOfEventsGreaterThanSeven () {
            System.out.println("����� � ������� ���������� � �������� � ����������� 7 � ����");
            info.stream().filter(x-> Integer.parseInt(x[1]) >= 7).forEach(x-> System.out.println(Arrays.toString(x)));
        }

        private void displayingTheNumberOfEventsGreaterThanSeven () {
            long countEvent = info.stream().filter(x-> Integer.parseInt(x[1]) >= 7).count();
            System.out.printf("���� �� ������ \"%s\" �������� %d ��������� � ����������� 7 � ����\n", filename, countEvent);
        }
    }
}
