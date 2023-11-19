package com.local.project.lesson20;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>\
        Map<Student.Gender, ArrayList<Student>> genderStudentMap = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(genderStudentMap);
        System.out.println();

        //  2. Найти средний возраст учеников
        OptionalDouble optionalAverageAge = students.stream()
                .mapToDouble(student -> (Period.between(student.getBirth(), LocalDate.now()).getYears()))
                .average();
        optionalAverageAge.ifPresentOrElse(x -> System.out.printf("%.2f\n", x),
                () -> System.out.println("Значение отсутствует"));
        System.out.println();


        //  3. Найти самого младшего ученика - Stream -> min(Comparator<Student>): int compare(T o1, T o2);  ОБЯЗАТЕЛЬНО ВЫУЧИТЬ OPTIONAL

        OptionalInt youngestStudent = students.stream()
                .mapToInt(student -> LocalDate.now().getYear() - student.getBirth().getYear())
                .min();
        if(youngestStudent.isPresent()) {
            System.out.println(youngestStudent.getAsInt());
        }
        else System.out.println("Значение отсутствует");
        System.out.println();

        //  5. Собрать учеников в группы по году рождения, результат - Map<Integer, List<Student>>
        Map<Integer, List<Student>> studentsByYearOfBirth = students.stream()
                .collect(Collectors.groupingBy(student -> student.getBirth().getYear()));
        System.out.println(studentsByYearOfBirth);
        System.out.println();

        //  6. Отсортировать по полу, дате рождения, имени (в обратном порядке), собрать в список (ArrayList)
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
        // 7. Собрать в список всех учеников с именем == someName
        String someName = "Алена";
            List<Student> someNameListStudents = students.stream()
                    .filter(student -> student.getName().equals(someName))
                    .toList();
            System.out.println(someNameListStudents);
        System.out.println();



        //  8. Собрать Map<Student.Gender, Integer>,
        //  где Student.Gender - пол,
        //  Integer - суммарный возраст учеников данного пола

        Map<Student.Gender, Integer> sumAgeStudent= students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.summingInt(student -> LocalDate.now().getYear() - student.getBirth().getYear())));
        System.out.println(sumAgeStudent);
        System.out.println();



        // Collectors
        // reducing()  - reduce() - операция сокращения, типа конкатенации элементов стрима в единый элемент
        // minBy() maxBy()  - - возвращают минимальный и максимальный элемент Otional<T> ...должен быть реальзован метод Comparing
        // teeing() flatMapping()
        // joining() - склеивает элементы в строку, возвращает String
        // summingInt() - возвращает сумму
        // averagingInt() / averagingLong() / averagingDouble()  - возвращает среднее значение элемента в типа int, long, dooble
        // summarizingDouble() / summarizingInt() / summarizingLong() - позволяют объединить данные в набор
        // объекта IntSummaryStatistics, для дальнейшего применения к ним методов:
//        getAverage(): возвращает среднее значение
//        getCount(): возвращает количество элементов в наборе
//        getMax(): возвращает максимальное значение
//        getMin(): возвращает минимальное значение
//        getSum(): возвращает сумму элементов
//        accept(): добавляет в набор новый элемент

    }
}