package com.local.project.lesson18;
import com.local.project.lesson1516.homeTask16.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class Lesson18 {
    public static void main(String[] args) {
//        Operation: double action(double a, double b);

        Operation plus  = (first, second) -> first + second;
        System.out.println(plus.action(45, 90));

        Operation minus  = (first, second) -> first - second;
        System.out.println(minus.action(45, 90));

        Operation div  = (first, second) -> {
            if (second == 0) throw new IllegalArgumentException("second not null");
            return first / second;
        };
        System.out.println(div.action(90, 0));

        Operation sub  = (first, second) -> first * second;
        System.out.println(sub.action(45, 90));

        Operation min = (a, b) -> a < b ? a : b;

        // объекты, созданные через л€мбда, можно передавать в методы, как любые другие экземпл€ры
        printOperationResult(min, 12.3, 9.9);
        printOperationResult((a, b) -> a > b ? a : b, 12.43,56.7);

        Operation operation = plus.addOperation(minus).addOperation(div). addOperation(sub);
    }
    private static void printOperationResult(Operation operation, double a, double b) {
        System.out.println(operation.action(a, b));


        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(875, -78, 12, 56, 34, -89, 0, 344));
        Predicate<Integer> negative = x -> x<0;
        integers.removeIf(negative);
        /*Iterator<Integer> iterator = integers.iterator();  // это происходит под капотом
        while(iterator.hasNext()) {
            if (negative.test(iterator.next())) iterator.remove();
        }*/
        integers.removeIf(x -> x == 100);


        ArrayList<String> files = new ArrayList<>(Arrays.asList("01.txt", "02.json", "03.txt", "04.txt", "05.properties"));
        // оставить в коллекции json u properties
        files.removeIf(line -> !line.endsWith(".json") && !line.endsWith(".properties"));
        System.out.println(files);

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
        fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));
        fruits.removeIf(line -> line.getType()== Fruit.FruitType.BANANA && line.getPrice()<100);

        Comparator<Fruit> compareByPrice = (x, y) -> (int)(x.getPrice() - y.getPrice());
        Comparator<Fruit> compareByCount = (f1, f2) -> f2.getCount() - f1.getCount();
        fruits.sort(compareByCount);
        fruits.sort(compareByPrice.thenComparing(compareByCount));




        fruits.forEach(line -> {
            if (line.getType() == Fruit.FruitType.APPLE || line.getType() == Fruit.FruitType.APPLE)
                System.out.println(String.format("%s price - %s", line, line.getPrice()));
        });
        fruits.forEach(line -> line.setPrice(line.getPrice()*2));
        fruits.forEach(line -> {
            if (line.getType() == Fruit.FruitType.APPLE || line.getType() == Fruit.FruitType.APPLE)
                System.out.println(String.format("%s price - %s", line, line.getPrice()));
        });





    }
//    private static <T extends Fruit> ArrayList<T> go( ArrayList<T> fruitsList, Predicate<? super Fruit> filter){
//        ArrayList<T> fruits01 = new ArrayList<>();
////        for (T fruit : fruitsList) {
////            if (filter.test(fruit))
////                fruits01.add(fruit);
////        }
////        return ArrayList<T> fruits01 = fruitsList.removeIf(fruit -> !filter.test(fruit));
//
//    }

//    ”читыва€, что Comparator - функциональный интерфейс,
//    отсортировать список фруктов:
//            1. по цене
//  2. по цене и количеству



}
