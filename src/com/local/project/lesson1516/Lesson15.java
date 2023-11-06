package com.local.project.lesson1516;

import com.local.project.lesson1516.customlist.User;

import java.util.*;

// �� ���������������� ���������
public class Lesson15 {
    public static void main(String[] args) {
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

//        Iterator<String> iterator = strings.iterator(); // ��� ������ � ������� ��������� ��� ����� ����������
//        while (iterator.hasNext()) {
//            String element = iterator.next();
//         //   System.out.println(element.toUpperCase());
//            if ("������".equalsIgnoreCase(element)) {
//                iterator.remove(); // ������� ������ ���
//            }

          //  strings.removeIf(string -> string.equalsIgnoreCase("������"));
//        }
        // List: ArrayList, LinkedList   - ������
        // 1. ����������� ������ � ���������
        // 2. �������� �������� � ������� ����������
        // 3. ����� �������� null
        // 4. ����� ��������� ����������� ��������

        // �������
        // ��������� Set:
        // 1. �� ��������� ������� ������������� ��������
        // 2. ����������� �������� null � ������� �������� ��������� ������� �� ���������� ����������
        // 3. ������ ���������� ����� fori !!!
        // 4� ������� �������� ��������� ����� ���������� �� ������� ����������

        // ���������� �� ������ ���-�������
        HashSet<Integer> integerHashSet = new HashSet<>();
        // ���-�������[null,  , , , , 4 , , ,3 , , , 10]
        integerHashSet.add(4);
        integerHashSet.add(6);
        integerHashSet.add(4); // ������ false
        integerHashSet.add(7);
        integerHashSet.add(70);
        integerHashSet.add(145);
        integerHashSet.add(null);
        // integerHashSet.add(null); ��������� �������� null
        System.out.println(integerHashSet);
        System.out.println(integerHashSet.add(176));




        // ��� ����� TreeSet, ����������� � TreeSet ������ ����������� ���� �� �������
        // ��������� ����������� ������� - implements Comparable<>
        // ��������� Comporator �������� � HashSet

        TreeSet<String> stringTreeSet = new TreeSet<>();
        stringTreeSet.add("1");
        stringTreeSet.add("145");
        stringTreeSet.add("45");
        stringTreeSet.add("3");
        stringTreeSet.add("0");
        stringTreeSet.add(null); //�� ��������� ������� � ��������� null - > ������� NullPointerException

        Comparator<User> byName = new User.NameComparator();
        Comparator<User> bySalary = new User.SalaryComparator();
        Comparator<User> byBirth = new User.BirthComparator();

        Comparator<User> byNameThenBySalary = byName.thenComparing(bySalary).thenComparing(byBirth);
        // ������������ ����������, ���� ������ Comparator ������ 0 (������� �� ������, ����� �� ��������, ����� �� ��� ��������

        TreeSet<User> user01 = new TreeSet<>(byNameThenBySalary);
    }
}
