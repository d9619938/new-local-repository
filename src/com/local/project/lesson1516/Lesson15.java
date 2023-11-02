package com.local.project.lesson1516;

import java.util.*;

// НЕ потокобезопасные коллекции
public class Lesson15 {
    public static void main (String[] args) {
//        LinkedList<String> strings01 = new LinkedList<>(); // Самый общий тип LinkedList
        Set<String> strings01 = new HashSet<>(Arrays.asList("Саратов", "Новгород"));
        System.out.println(strings01);
//        List<String> s02 = new LinkedList<>();
//        Deque<String> s03 = new LinkedList<>();
//        Cloneable<String> s04 = new LinkedList<>();
        System.out.println(strings01.size()); // 0
        strings01.add("Тверь");
        strings01.add("Москва");
        System.out.println(strings01);

        LinkedList<String> strings = new LinkedList<>(strings01);
        strings.add("Казань");
        strings.add("Самара");
        strings.add(null);
        System.out.println(strings);


    ArrayList<String> stringsArrayList = new ArrayList<>(40); // создание АррайЛиста с
                                                                    // первоначальным массивом на 49 эл.

        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.size()); // 0
        integers.add(3);
        integers.add(6);
        integers.add(90);
        //integers.trimToSize(); // сокращает внутренний массив до текущего size


        for (Integer integer : integers) {
            System.out.println(integer);
         //   integers.remove(integer); вызов метода remove приведет к ошибке!!!
        }

        Iterator<String> iterator = strings.iterator(); // тип данных в скобках указываем что будем перебирать
    while (iterator.hasNext()) {
        String element = iterator.next();
        System.out.println(element.toUpperCase());
        if ("самара".equalsIgnoreCase(element)) {
            iterator.remove(); // удалять только так
        }

        strings.removeIf(string -> string.equalsIgnoreCase("самара"));
    }
    }
}
