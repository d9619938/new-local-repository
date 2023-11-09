package com.local.project.lesson17.task;

import java.util.*;

public class HomeTask01 {
    private static final String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
            "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
            "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
            "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
            "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
            " sometimes on purpose injected humour and the like";

    public static void main(String[] args) {
        HomeTask01 task01 = new HomeTask01();
        task01.mission01();
        System.out.println();

        task01.mission02();
        System.out.println();

        task01.mission03();
        System.out.println();

        task01.mission04();   // не пришла идея как реализовать...надо думать




    }

    private static Map<String, Long> addMapString(Collection<String> strings) {
        //        Реализовать статический метод, который принимает Collection<String> strings и возвращает количество
        //        одинаковых слов в коллекции strings в виде Map<String, Long>.
        //        Где ключи - слова, а значения - количество повторений.
        if (strings == null) throw new IllegalArgumentException("strings not null");
        Map<String, Long> stringLongMap = new HashMap<>();
        for (String str : strings) {  // перебираем коллекцию строк
            if (str != null) str = str.toLowerCase();
            if (stringLongMap.containsKey(str)) {
                stringLongMap.put(str, stringLongMap.get(str) + 1); // устанавливаем значение для второго вхождения
            } else {
                stringLongMap.put(str, 1L);  // устанавливаем дефолтное значение для первого вхождения
            }
        }
        return stringLongMap;
    }

    private static Long numberOfOccurrences(String word, String text) {
        //Реализовать статический метод, принимающий на вход String word и String text и возвращающий
        // частоту встречаемости слова word в тексте text в виде Map<String, Long>.
        // Где ключ - слово, а значение - частота встречаемости
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>();
        for (String w : results) {
            strings.add(w.toLowerCase());
        }
        Map<String, Long> map = addMapString(strings);
        return map.get(word.toLowerCase().trim());
    }

    private static Map<Integer, List<String>> getIntegerListMap(String text) {
//        Реализовать статический метод, принимающий на вход String text и возвращающий
//        Map<Integer, List<String>> где ключи - количество букв в словах,
//        значения - списки соответствующих слов.
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>(); // коллекция тут явно лишняя, надо пробовать без нее...
        int maxWord = 0;
        for (String w : results) {
            strings.add(w);
            int wLength = w.length();
            maxWord = Math.max(maxWord, wLength);
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 1; i <= maxWord; i++) {
            List<String> stringList = new ArrayList<>();
            for (String str : strings) {
                str = str.toLowerCase();
                if (str.length() == i && !stringList.contains(str)) {
                    stringList.addFirst(str);
                }
            }
            map.put(i, stringList);
        }
        return map;
    }

    private static void getTop10(String text) {
//        Реализовать статический void метод, принимающий на вход String text и выводящий в консоль топ 10
//        самых часто встречаемых в тексте слов (можно добавить условие: артикли и предлоги не считаем за слова).
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>(); // коллекция тут явно лишняя, надо пробовать без нее...
        for (String w : results) {
            strings.add(w);
        }
        Map<String, Long> map = addMapString(strings);
        Set<Map.Entry<String, Long>> mapEntry = map.entrySet();
        TreeSet<Long> longs = new TreeSet<>();
        for (Map.Entry<String, Long> m : mapEntry) {
            if (m.getKey().length() > 3)
                longs.add(m.getValue());
        }
    }
        // дальше надо думать.....

//        long x = longs.getLast();
//        while (x>=0)
//        for (Map.Entry<String, Long> m : mapEntry) {
//            if (m.getValue() == x) {
//                System.out.println(m.getKey() + " встречается в тексте " + m.getValue() + " раз(а)");
//                --x;
//
//            }
//
//        }
//        long x = longs.getLast();
//        for (long i = longs.size()-1L; i >= 0L ; i--, x--) {
//            System.out.println(x);
//
//        }
//    }

//        System.out.println(longs.sort(););




        private void mission01() {
            Collection<String> strings = new ArrayList<>();
            strings.add("СПБ");
            strings.add("Москва");
            strings.add("СПБ");
            strings.add("Воронеж");
            strings.add(null);
            strings.add("СПБ");
            strings.add("Воронеж");
            strings.add("Воронеж");
            strings.add(null);
            strings.add("СПБ");

            System.out.println();
            System.out.println("Задание 1: Результата работы метода addMapString()");
            System.out.println(addMapString(strings));
        }
        private void mission02() {
            String word = "   Content ";
            System.out.println("Задание 2: Результат работы метода numberOfOccurrences (String word, String text)");
            System.out.println(String.format("Слово \"%s\" встречается в тексте %d раз(а)", word, numberOfOccurrences(word, text)));
        }
        private void mission03() {
            System.out.println("Задание 3: Результат работы метода getIntegerListMap");
            System.out.println(getIntegerListMap(text));
        }
        private void mission04() {
        getTop10(text);
        }

    }

