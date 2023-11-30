package com.local.project.lesson25;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Lesson25 {
    public static void main(String[] args) {
        Rate full = new Rate(1, Rate.RateType.FULL);

        Trader trader = new Trader(1, new ArrayList<>(), full, "qwerty", "12345");

        Item item01 = new Item(1, "����", 12000, trader);
        Item item02 = new Item(2, "�����", 78000, trader);
        Item item03 = new Item(3, "����", 4500, trader);
        Item item04 = new Item(4, "������", 9300, trader);

        trader.addItem(item01);
        trader.addItem(item02);
        trader.addItem(item03);
        trader.addItem(item04);

        write(full);   // ���� ���������� �������� ��������� ������ ������, �� �� ���������� ��������� � ����, ��� ����� �����
        write(item02);  // � ����� �������� ���� ����
        write(trader);

//        List<Item> list = Arrays.asList(item01, item02, item03));
//        write(list);

        Rate fullFromFile = read();
        System.out.println(fullFromFile.equals(full));

        Item itemFromFile = read();
        System.out.println(itemFromFile.equals(item01));

        Trader traderFromFile = read();
        System.out.println(traderFromFile.equals(trader));
    }
    public static <T> void write(T t) {
        try(FileOutputStream fileOutput = new FileOutputStream("file.bin", true); // true - ����� � �����
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
//            try {
                objectOutput.writeObject(t);
//            }catch (IOException e) {
//                System.out.println("������ ������������ writeObject");
//            }
        } catch (FileNotFoundException e) {
            System.out.println("������ �������� �����");
        } catch (IOException e) {
            System.out.println("������ ������������ writeObject ��� ������ � ����");;
        }
    }

    public static <T> T read() {
        try (FileInputStream fileInput = new FileInputStream("file.bin");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            return (T) objectInput.readObject(); // ������, �������������� � Object
        } catch (FileNotFoundException e) {
            System.out.println("���� �� ������");
        }catch (IOException e) {
            System.out.println("������ ������");
        }catch (ClassNotFoundException e) {
            System.out.println("������ ��������������, ������ ����� �� ������");
        }
        return null;
    }
}
