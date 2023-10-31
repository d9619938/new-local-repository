package com.local.project.lesson13;

public class PrimitiveWrappers {
    public static void main(String[] args) {
        int num = 567;
        Integer count = 34;

        /*
        Integer count = new Integer(34);  - ���� ������� �� ������������...������ ���
*/

        // ������������ - ���������� ������-������� ������������� �������� ���������
     Integer age = 20;  // ������������
     count = num;       // ������������


        // �������������� - ���������� ������������ ���� ������������� �������� �������
        double price;
        Double value = 45.6; // ��������������
        price = value; // ��������������

        // ������� ������������ � ��������������
        // 1. ������������ �� ��������, ���� �������� �� ������������� ������ �������
        byte oneB = 1;
        // Integer oneI = oneB; �� ��������, �.�. ��������� ����� ����������
        Integer oneI = (int)oneB;

        // 2. �� �������������� ������� �1 �� ����������������
        //3. ��������� ������� ����������� �������� ������������ � ��������������
        // 4. ������������ � �������������� �� �������� � ���������,
        // �.�. ������ ������� �� ����������� ������������� � ������ ����������

        Integer x = 9;
        Integer y = 9;
        System.out.println(x==y);        //true
        System.out.println(x.equals(y)); //true

        Integer k = 900;
        Integer l = 900;
        System.out.println(k==l);        //false
        System.out.println(k.equals(l)); // true

    }

}
