package com.local.project.lesson1516;

import java.util.*;

// �� ���������������� ���������
public class Lesson15 {
    public static void main (String[] args) {
//        LinkedList<String> strings01 = new LinkedList<>(); // ����� ����� ��� LinkedList
        Set<String> strings01 = new HashSet<>(Arrays.asList("�������", "��������"));
        System.out.println(strings01);
//        List<String> s02 = new LinkedList<>();
//        Deque<String> s03 = new LinkedList<>();
//        Cloneable<String> s04 = new LinkedList<>();
        System.out.println(strings01.size()); // 0
        strings01.add("�����");
        strings01.add("������");
        System.out.println(strings01);

        LinkedList<String> strings = new LinkedList<>(strings01);
        strings.add("������");
        strings.add("������");
        strings.add(null);
        System.out.println(strings);


    ArrayList<String> stringsArrayList = new ArrayList<>(40); // �������� ���������� �
                                                                    // �������������� �������� �� 49 ��.

        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.size()); // 0
        integers.add(3);
        integers.add(6);
        integers.add(90);
        //integers.trimToSize(); // ��������� ���������� ������ �� �������� size


        for (Integer integer : integers) {
            System.out.println(integer);
         //   integers.remove(integer); ����� ������ remove �������� � ������!!!
        }

        Iterator<String> iterator = strings.iterator(); // ��� ������ � ������� ��������� ��� ����� ����������
    while (iterator.hasNext()) {
        String element = iterator.next();
        System.out.println(element.toUpperCase());
        if ("������".equalsIgnoreCase(element)) {
            iterator.remove(); // ������� ������ ���
        }

        strings.removeIf(string -> string.equalsIgnoreCase("������"));
    }
    }
}
