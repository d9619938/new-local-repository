package com.local.project.lesson12.exception;

public class Exceptions {
    public static void main(String[] args) {
        // ���������� ������� ���������� (���������� RuntimeException)
        // ���������������� (unchecked) - ����� �����������, ����� �� ������������
        int [] ints = new int[4];
        int index = 9;
        ints[index] = 5; // java.lang.ArrayIndexOutBoundsException

        Object object = "Hello"; // � ������� ��� ������ String
        Integer integer = (Integer) object; //ClassCastException, ������� � �������������� ����

        System.out.println(4/0); // ArithmeticException
        String string = null;
        System.out.println(string.length()); // NullPointerException

        // ��� ���������� (������� ���������� � ���������� �������������� � try-catch)

        try {
            // ������������ ������� ���
            System.out.println(string.length()); // ���� ��� ��������� ����������, �� ���������� ��������� � ���� catch

        } catch (NullPointerException e) {
            System.out.println(" "); // ���������� ��� ����� ��������� ����������
            e.getCause(); // - ������� ����������
            e.getMessage(); // - ��������� �� ������, ��� �������� ��� ��� ���������
        }

        try {
            //  ������������ ������� ���
            System.out.println(string.length());
            Integer integer01 = (Integer) object;
        } catch (NullPointerException e) {  // ��������� ������, ���� ���� ������������� ����������� �� ������ ����������
            System.out.println(e.getMessage());
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        try {
            // ������������ ������� ���
        } catch (NullPointerException | ClassCastException e) {  // ������������ ��������� ���
            System.out.println(e.getMessage());
        }
        // � ����� try-catch �� �������������� �������� �� ��� ����������!!!

        try {
            //  ������������ ������� ���
            System.out.println(string.length());
        } catch (RuntimeException e) { // ��� ���������� ������� ����������
            System.out.println(e.getMessage());
        }

        // ���� ���������� ���������� ��������� ����������, �� ���������� � ������ ��������� �� �� ��������� � �������������

        try {
            User user = new User(3);
            User copy = user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
