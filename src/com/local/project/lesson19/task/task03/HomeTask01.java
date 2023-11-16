package com.local.project.lesson19.task.task03;

import com.local.project.lesson14.properties.vehicle.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HomeTask01 {

    public static void main(String[] args) {
//       Задание №1
        // в чём разница между методами peek и map? peek() используется для генерации промежуточных результатов операции.
        // Таким образом можно выводить в консоль результаты работы после каждой промежуточной операции
        // map() - выполняет работу над элементами потока, без возможности вывода результата.


        // в чём разница между методами peek и foreach?
        // peek() - промежуточная операция, которая включается в работу только при наличии завершающей терминальной операции.
        // Генерирует значения элементов в процессе выполнения промежуточных операций
        // forEach() - терминальная операция, после которой закрывается поток, но она дает старт всем промежуточным операциям.
        // Генерирует финальные значения элементов потока, после всех обработок.

        // в чём разница между методами map и flatMap?
        // map() - позволяет выполнить операцию над каждым элементов потока в отдельности
        // flatMap() - объединяет элементы потока в единый поток, актуально для массивов строк например...выравнивает все элементы
        // в единый поток элементов, для дальнейшей работы с элементами как с единым потоком

        //в чём разница между методами map и mapToInt?
        // map() преобразует элемент потока или тип элемента потока согласно инструкции в методе в любой сопоставимый тип.
        // mapToInt() преобразует элемент потока в целочисленный тип, согласно инструкции
        List<Car> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.ORANGE, "002"),
                new MiniCar(Repaintable.Color.BLACK, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new Car(Repaintable.Color.BLACK, "005"),
                new MiniCar(Repaintable.Color.ORANGE, "006")
        );

        int i = 0;
        for (Car c : vehicles) {  // задаю уровень износа
            c.incLevelOfWare(++i);
        }

    mission_2_1(vehicles);
    mission_2_2(vehicles);
    mission_2_3(vehicles);


    }

    private static void mission_2_1(List<Car> vehicles) {
        System.out.println("""

                Задание 2.1
                -отсортировать по уровню износа от большего к меньшему .sorted(Comparator comparator)
                -получить список номеров транспортных средств .toList()
                """);

        List<String> sortedVehicles = vehicles.stream().
                sorted((o1, o2) -> o2.getLevelOfWare() - o1.getLevelOfWare()). // сортирую поток по убыванию
                        peek(vehicle -> System.out.println("Проверка сортировки по уровню износа - " + vehicle.getLevelOfWare())). // промежуточно проверяю сортировку
                        map(Vehicle::getNumber).toList();                              // получаю поток номеров ТС, извлекаю в List.

        System.out.println("\nОтсортированный список номеров ТС:\n");
        for (String c : sortedVehicles) {                                     // вывожу в консоль результат работы
            System.out.println("Номер транспортного средства - " + c);
        }
    }

    private static void mission_2_2(List<Car> vehicles) {
        System.out.println("\nЗадание 2.2\n" +
                "-получить суммарный уровень износа транспортных средств .mapToInt(ToIntFunction function) и .sum()\n");

        int sumLevelOfWare = vehicles.stream().
                mapToInt(Vehicle::getLevelOfWare).sum(); // привожу поток к целочисленному, суммирую элементы потока
        System.out.println("Суммарный уровень износа транспортных средств: " + sumLevelOfWare);
    }

    private static void mission_2_3(List<Car> vehicles) {
        System.out.println("\nЗадание 2.3\n" +
                "-сменить цвет каждой машины на GOLD .peek(Consumer consumer)\n" +
                "-вывести каждый элемент в консоль .foreach(Consumer consumer)\n");

        List<Car> changeColorVehicles = vehicles.stream()
                .peek(vehicle -> System.out.println("транспортное средство перекрашено в GOLD?- " + vehicle.changeColor(Repaintable.Color.GOLD))).toList();

        System.out.println();
        for (Car car : changeColorVehicles) {
            System.out.println(car);
        }


    }

}
