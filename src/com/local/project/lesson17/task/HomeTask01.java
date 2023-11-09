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

        task01.mission04();   // �� ������ ���� ��� �����������...���� ������




    }

    private static Map<String, Long> addMapString(Collection<String> strings) {
        //        ����������� ����������� �����, ������� ��������� Collection<String> strings � ���������� ����������
        //        ���������� ���� � ��������� strings � ���� Map<String, Long>.
        //        ��� ����� - �����, � �������� - ���������� ����������.
        if (strings == null) throw new IllegalArgumentException("strings not null");
        Map<String, Long> stringLongMap = new HashMap<>();
        for (String str : strings) {  // ���������� ��������� �����
            if (str != null) str = str.toLowerCase();
            if (stringLongMap.containsKey(str)) {
                stringLongMap.put(str, stringLongMap.get(str) + 1); // ������������� �������� ��� ������� ���������
            } else {
                stringLongMap.put(str, 1L);  // ������������� ��������� �������� ��� ������� ���������
            }
        }
        return stringLongMap;
    }

    private static Long numberOfOccurrences(String word, String text) {
        //����������� ����������� �����, ����������� �� ���� String word � String text � ������������
        // ������� ������������� ����� word � ������ text � ���� Map<String, Long>.
        // ��� ���� - �����, � �������� - ������� �������������
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
//        ����������� ����������� �����, ����������� �� ���� String text � ������������
//        Map<Integer, List<String>> ��� ����� - ���������� ���� � ������,
//        �������� - ������ ��������������� ����.
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>(); // ��������� ��� ���� ������, ���� ��������� ��� ���...
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
//        ����������� ����������� void �����, ����������� �� ���� String text � ��������� � ������� ��� 10
//        ����� ����� ����������� � ������ ���� (����� �������� �������: ������� � �������� �� ������� �� �����).
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>(); // ��������� ��� ���� ������, ���� ��������� ��� ���...
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
        // ������ ���� ������.....

//        long x = longs.getLast();
//        while (x>=0)
//        for (Map.Entry<String, Long> m : mapEntry) {
//            if (m.getValue() == x) {
//                System.out.println(m.getKey() + " ����������� � ������ " + m.getValue() + " ���(�)");
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
            strings.add("���");
            strings.add("������");
            strings.add("���");
            strings.add("�������");
            strings.add(null);
            strings.add("���");
            strings.add("�������");
            strings.add("�������");
            strings.add(null);
            strings.add("���");

            System.out.println();
            System.out.println("������� 1: ���������� ������ ������ addMapString()");
            System.out.println(addMapString(strings));
        }
        private void mission02() {
            String word = "   Content ";
            System.out.println("������� 2: ��������� ������ ������ numberOfOccurrences (String word, String text)");
            System.out.println(String.format("����� \"%s\" ����������� � ������ %d ���(�)", word, numberOfOccurrences(word, text)));
        }
        private void mission03() {
            System.out.println("������� 3: ��������� ������ ������ getIntegerListMap");
            System.out.println(getIntegerListMap(text));
        }
        private void mission04() {
        getTop10(text);
        }

    }

