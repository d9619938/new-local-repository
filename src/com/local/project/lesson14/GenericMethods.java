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
    // Generic типы существуют только на этапе компиляции
    // во время выполнения программы их не существует.
    // Generic компилируются в отдельные типы
    // С ПРИМИТИВАМИ НЕ РАБОТАЕТ

    // Стирание типовЖ
    // 1. Generic без ограничений компилируются в Object
    // 2. Generic c ограничениями компилируются в тип ограничения


    // Типизированные (Generic) методы
    // могут принимать на вход и возвращать generic типы
    // generic без ограничений (unbounded)
    public static <T> boolean inArray(T[] array, T element) {
        if (array == null || element == null) return false;
        for (T elem : array) {
            if (elem.equals(element)) return true;
        }
        return false;
    }

    // generic c ограничениями (bounded)
    // <T, K> могут быть вообще не связаны между собой
    // extends -  в данном случае ограничение,
    // T - компилируется в Number
    // K - компилируется в Temporal
     public static <T extends Number, K extends Temporal>  int compareHashCodes(T firsrt, K second) {
         System.out.println(firsrt.longValue());
         System.out.println(second.plus(Duration.ofHours(3)));
        return Integer.compare(firsrt.hashCode(), second.hashCode());
    }

    public static void main(String[] args) {
    String[]strings = {"red", "blue", "pink"};
    String string = "yellow";

    // <String> указывает на то, что в метод можно передать указанный тип и его методы

    boolean res = GenericMethods.<String>inArray(strings, string);

    Integer[] integers = { 45, 89, 0, 34, -1};
    Integer integer = 3;

    // <Number> указывает на то, что в метод можно передать указанный тип
        // и его подтипы (обертки примитивов Integer, Byte и т.д)
    res = GenericMethods.<Number>inArray(integers, integer);

        int result = GenericMethods.<Number, LocalDate>compareHashCodes(integer, LocalDate.now());
    }
}
