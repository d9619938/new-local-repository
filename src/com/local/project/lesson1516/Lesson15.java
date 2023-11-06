package com.local.project.lesson1516;

import com.local.project.lesson1516.customlist.User;

import java.util.*;

// НЕ потокобезопасные коллекции
public class Lesson15 {
    public static void main(String[] args) {
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

//        Iterator<String> iterator = strings.iterator(); // тип данных в скобках указываем что будем перебирать
//        while (iterator.hasNext()) {
//            String element = iterator.next();
//         //   System.out.println(element.toUpperCase());
//            if ("самара".equalsIgnoreCase(element)) {
//                iterator.remove(); // удалять только так
//            }

          //  strings.removeIf(string -> string.equalsIgnoreCase("самара"));
//        }
        // List: ArrayList, LinkedList   - Списки
        // 1. возможность работы с индексами
        // 2. элементы хранятся в порядке добавления
        // 3. можно добавить null
        // 4. могут содержать дублирующие элементы

        // ОЧЕРЕДИ
        // Множества Set:
        // 1. не позволяют хранить дублирующиеся элементы
        // 2. возможность добавить null и порядок хранения элементов зависят от конкретной реализации
        // 3. нельзя перебирать через fori !!!
        // 4ю порядок хранения элементов может отличаться от порядка добавления

        // реализован на основе хеш-таблицы
        HashSet<Integer> integerHashSet = new HashSet<>();
        // хеш-таблица[null,  , , , , 4 , , ,3 , , , 10]
        integerHashSet.add(4);
        integerHashSet.add(6);
        integerHashSet.add(4); // вернет false
        integerHashSet.add(7);
        integerHashSet.add(70);
        integerHashSet.add(145);
        integerHashSet.add(null);
        // integerHashSet.add(null); позволяет добавить null
        System.out.println(integerHashSet);
        System.out.println(integerHashSet.add(176));




        // Для типов TreeSet, добавляемых в TreeSet должно выполняться одно из условий
        // Определен натуральный порядок - implements Comparable<>
        // экземпляр Comporator передать в HashSet

        TreeSet<String> stringTreeSet = new TreeSet<>();
        stringTreeSet.add("1");
        stringTreeSet.add("145");
        stringTreeSet.add("45");
        stringTreeSet.add("3");
        stringTreeSet.add("0");
        stringTreeSet.add(null); //не позволяет хранить и добавлять null - > выкинет NullPointerException

        Comparator<User> byName = new User.NameComparator();
        Comparator<User> bySalary = new User.SalaryComparator();
        Comparator<User> byBirth = new User.BirthComparator();

        Comparator<User> byNameThenBySalary = byName.thenComparing(bySalary).thenComparing(byBirth);
        // сравнивается поочередно, если первый Comparator вернет 0 (сначала по именам, потом по зарплате, потом по дню рождения

        TreeSet<User> user01 = new TreeSet<>(byNameThenBySalary);
    }
}
