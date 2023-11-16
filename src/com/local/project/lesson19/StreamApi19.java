package com.local.project.lesson19;


import com.local.project.lesson14.properties.vehicle.*;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi19 {
    public static void main(String[] args) {
        Stream<Integer> values = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        List<Repaintable> repaintables = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.BLACK, "002"),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new MiniCar(Repaintable.Color.BLUE, "005"),
                new Car(Repaintable.Color.BLACK, "006"),
                new Car(Repaintable.Color.ORANGE, "007")
        );
       // values.distinct().map(x -> x < 0 ? 0 : x).sorted().forEach(System.out::println);

        values.distinct()
                .map(integer -> integer < 0 ? 0 : integer)
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);

        long count = Arrays.stream(colors).filter(color -> !color.contains("yellow")).count();
        System.out.println(count);
        System.out.println();

        List<Repaintable.Color> list = repaintables.stream().map(repaintable -> repaintable.getColor()).distinct().toList();
            System.out.println(list);

        List<Vehicle> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new Train("002", 10, true),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Bus("004"),
                new Train("005", 15, false),
                new Car(Repaintable.Color.BLACK, "006"),
                new MiniCar(Repaintable.Color.ORANGE, "007")
        );
    }
}
