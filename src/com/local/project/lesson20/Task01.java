package com.local.project.lesson20;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "����", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "����", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "����", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "�������", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "����", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "����", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "����", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "��������", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // ��������� ������ Stream API:
        //  1. ��������� �������� �� ��� ������: ��������� � �������. ���������: Map<Student.Gender, ArrayList<Student>>\
        Map<Student.Gender, ArrayList<Student>> genderStudentMap = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(genderStudentMap);
        System.out.println();

        //  2. ����� ������� ������� ��������
        OptionalDouble optionalAverageAge = students.stream()
                .mapToDouble(student -> (Period.between(student.getBirth(), LocalDate.now()).getYears()))
                .average();
        optionalAverageAge.ifPresentOrElse(x -> System.out.printf("%.2f\n", x),
                () -> System.out.println("�������� �����������"));
        System.out.println();


        //  3. ����� ������ �������� ������� - Stream -> min(Comparator<Student>): int compare(T o1, T o2);  ����������� ������� OPTIONAL

        OptionalInt youngestStudent = students.stream()
                .mapToInt(student -> LocalDate.now().getYear() - student.getBirth().getYear())
                .min();
        if(youngestStudent.isPresent()) {
            System.out.println(youngestStudent.getAsInt());
        }
        else System.out.println("�������� �����������");
        System.out.println();

        //  5. ������� �������� � ������ �� ���� ��������, ��������� - Map<Integer, List<Student>>
        Map<Integer, List<Student>> studentsByYearOfBirth = students.stream()
                .collect(Collectors.groupingBy(student -> student.getBirth().getYear()));
        System.out.println(studentsByYearOfBirth);
        System.out.println();

        //  6. ������������� �� ����, ���� ��������, ����� (� �������� �������), ������� � ������ (ArrayList)
            Comparator<Student> byGender = (s1, s2) -> s1.getGender().ordinal() - s2.getGender().ordinal();
            Comparator<Student> byBirth = (s1, s2) -> s1.getBirth().compareTo(s2.getBirth());
            Comparator<Student> studentComparator = byGender.thenComparing(byBirth);
            studentComparator = Comparator.<Student>comparingInt(student -> student.getGender().ordinal())
                    .thenComparing(Comparator.comparing(student -> student.getBirth()))
                    .thenComparing(student -> student.getName()).reversed();

            ArrayList<Student> sortStudent = students.stream()
                    .sorted(studentComparator).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sortStudent);
        System.out.println();
        // 7. ������� � ������ ���� �������� � ������ == someName
        String someName = "�����";
            List<Student> someNameListStudents = students.stream()
                    .filter(student -> student.getName().equals(someName))
                    .toList();
            System.out.println(someNameListStudents);
        System.out.println();



        //  8. ������� Map<Student.Gender, Integer>,
        //  ��� Student.Gender - ���,
        //  Integer - ��������� ������� �������� ������� ����

        Map<Student.Gender, Integer> sumAgeStudent= students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.summingInt(student -> LocalDate.now().getYear() - student.getBirth().getYear())));
        System.out.println(sumAgeStudent);
        System.out.println();



        // Collectors
        // reducing()  - reduce() - �������� ����������, ���� ������������ ��������� ������ � ������ �������
        // minBy() maxBy()  - - ���������� ����������� � ������������ ������� Otional<T> ...������ ���� ���������� ����� Comparing
        // teeing() flatMapping()
        // joining() - ��������� �������� � ������, ���������� String
        // summingInt() - ���������� �����
        // averagingInt() / averagingLong() / averagingDouble()  - ���������� ������� �������� �������� � ���� int, long, dooble
        // summarizingDouble() / summarizingInt() / summarizingLong() - ��������� ���������� ������ � �����
        // ������� IntSummaryStatistics, ��� ����������� ���������� � ��� �������:
//        getAverage(): ���������� ������� ��������
//        getCount(): ���������� ���������� ��������� � ������
//        getMax(): ���������� ������������ ��������
//        getMin(): ���������� ����������� ��������
//        getSum(): ���������� ����� ���������
//        accept(): ��������� � ����� ����� �������

    }
}