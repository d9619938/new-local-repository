package com.local.project.lesson13;

public class PrimitiveWrappers {
    public static void main(String[] args) {
        int num = 567;
        Integer count = 34;

        /*
        Integer count = new Integer(34);  - Этот вариант не используется...дурной тон
*/

        // автоупаковка - переменной класса-обертки присваивается значение примитива
     Integer age = 20;  // автоупаковка
     count = num;       // автоупаковка


        // автораспаковка - переменной примитивного типа присваивается значение обертки
        double price;
        Double value = 45.6; // автораспаковка
        price = value; // автораспаковка

        // Правила автоупаковки и автораспаковки
        // 1. автоупаковка не работает, если примитив не соответствует классу обертке
        byte oneB = 1;
        // Integer oneI = oneB; не работает, т.к. требуется явное приведение
        Integer oneI = (int)oneB;

        // 2. на автораспаковку правило №1 не распространяется
        //3. аргументы методов подчиняются правилам автоупаковки и автораспаковки
        // 4. автоупаковка и автораспаковка не работают с массивами,
        // т.е. массив обертки не превратится автоматически в массив примитивов

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
