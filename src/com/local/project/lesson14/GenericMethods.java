package com.local.project.lesson14;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
//import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalUnit;


public class GenericMethods {
    // Generic ���� ���������� ������ �� ����� ����������
    // �� ����� ���������� ��������� �� �� ����������.
    // Generic ������������� � ��������� ����
    // � ����������� �� ��������

    // �������� ������
    // 1. Generic ��� ����������� ������������� � Object
    // 2. Generic c ������������� ������������� � ��� �����������


    // �������������� (Generic) ������
    // ����� ��������� �� ���� � ���������� generic ����
    // generic ��� ����������� (unbounded)
    public static <T> boolean inArray(T[] array, T element) {
        if (array == null || element == null) return false;
        for (T elem : array) {
            if (elem.equals(element)) return true;
        }
        return false;
    }

    // generic c ������������� (bounded)
    // <T, K> ����� ���� ������ �� ������� ����� �����
    // extends -  � ������ ������ �����������,
    // T - ������������� � Number
    // K - ������������� � Temporal
     public static <T extends Number, K extends Temporal>  int compareHashCodes(T firsrt, K second) {
         System.out.println(firsrt.longValue());
         System.out.println(second.plus(Duration.ofHours(3)));
        return Integer.compare(firsrt.hashCode(), second.hashCode());
    }

    public static void main(String[] args) {
    String[]strings = {"red", "blue", "pink"};
    String string = "yellow";

    // <String> ��������� �� ��, ��� � ����� ����� �������� ��������� ��� � ��� ������

    boolean res = GenericMethods.<String>inArray(strings, string);

    Integer[] integers = { 45, 89, 0, 34, -1};
    Integer integer = 3;

    // <Number> ��������� �� ��, ��� � ����� ����� �������� ��������� ���
        // � ��� ������� (������� ���������� Integer, Byte � �.�)
    res = GenericMethods.<Number>inArray(integers, integer);

        int result = GenericMethods.<Number, LocalDate>compareHashCodes(integer, LocalDate.now());
    }
}
