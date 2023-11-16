package com.local.project.lesson19.task.task03;

import com.local.project.lesson14.properties.vehicle.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HomeTask01 {

    public static void main(String[] args) {
//       ������� �1
        // � ��� ������� ����� �������� peek � map? peek() ������������ ��� ��������� ������������� ����������� ��������.
        // ����� ������� ����� �������� � ������� ���������� ������ ����� ������ ������������� ��������
        // map() - ��������� ������ ��� ���������� ������, ��� ����������� ������ ����������.


        // � ��� ������� ����� �������� peek � foreach?
        // peek() - ������������� ��������, ������� ���������� � ������ ������ ��� ������� ����������� ������������ ��������.
        // ���������� �������� ��������� � �������� ���������� ������������� ��������
        // forEach() - ������������ ��������, ����� ������� ����������� �����, �� ��� ���� ����� ���� ������������� ���������.
        // ���������� ��������� �������� ��������� ������, ����� ���� ���������.

        // � ��� ������� ����� �������� map � flatMap?
        // map() - ��������� ��������� �������� ��� ������ ��������� ������ � �����������
        // flatMap() - ���������� �������� ������ � ������ �����, ��������� ��� �������� ����� ��������...����������� ��� ��������
        // � ������ ����� ���������, ��� ���������� ������ � ���������� ��� � ������ �������

        //� ��� ������� ����� �������� map � mapToInt?
        // map() ����������� ������� ������ ��� ��� �������� ������ �������� ���������� � ������ � ����� ������������ ���.
        // mapToInt() ����������� ������� ������ � ������������� ���, �������� ����������
        List<Car> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.ORANGE, "002"),
                new MiniCar(Repaintable.Color.BLACK, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new Car(Repaintable.Color.BLACK, "005"),
                new MiniCar(Repaintable.Color.ORANGE, "006")
        );

        int i = 0;
        for (Car c : vehicles) {  // ����� ������� ������
            c.incLevelOfWare(++i);
        }

    mission_2_1(vehicles);
    mission_2_2(vehicles);
    mission_2_3(vehicles);


    }

    private static void mission_2_1(List<Car> vehicles) {
        System.out.println("""

                ������� 2.1
                -������������� �� ������ ������ �� �������� � �������� .sorted(Comparator comparator)
                -�������� ������ ������� ������������ ������� .toList()
                """);

        List<String> sortedVehicles = vehicles.stream().
                sorted((o1, o2) -> o2.getLevelOfWare() - o1.getLevelOfWare()). // �������� ����� �� ��������
                        peek(vehicle -> System.out.println("�������� ���������� �� ������ ������ - " + vehicle.getLevelOfWare())). // ������������ �������� ����������
                        map(Vehicle::getNumber).toList();                              // ������� ����� ������� ��, �������� � List.

        System.out.println("\n��������������� ������ ������� ��:\n");
        for (String c : sortedVehicles) {                                     // ������ � ������� ��������� ������
            System.out.println("����� ������������� �������� - " + c);
        }
    }

    private static void mission_2_2(List<Car> vehicles) {
        System.out.println("\n������� 2.2\n" +
                "-�������� ��������� ������� ������ ������������ ������� .mapToInt(ToIntFunction function) � .sum()\n");

        int sumLevelOfWare = vehicles.stream().
                mapToInt(Vehicle::getLevelOfWare).sum(); // ������� ����� � ��������������, �������� �������� ������
        System.out.println("��������� ������� ������ ������������ �������: " + sumLevelOfWare);
    }

    private static void mission_2_3(List<Car> vehicles) {
        System.out.println("\n������� 2.3\n" +
                "-������� ���� ������ ������ �� GOLD .peek(Consumer consumer)\n" +
                "-������� ������ ������� � ������� .foreach(Consumer consumer)\n");

        List<Car> changeColorVehicles = vehicles.stream()
                .peek(vehicle -> System.out.println("������������ �������� ����������� � GOLD?- " + vehicle.changeColor(Repaintable.Color.GOLD))).toList();

        System.out.println();
        for (Car car : changeColorVehicles) {
            System.out.println(car);
        }


    }

}
