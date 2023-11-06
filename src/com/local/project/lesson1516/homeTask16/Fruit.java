package com.local.project.lesson1516.homeTask16;

import java.util.Comparator;
import java.util.Objects;

public class Fruit {
    private final FruitType type;
    private double price;
    private int count;

    // конструктор, принимающий значения всех свойств + проверки
    // доступные геттеры и сеттеры
    // equals + hashCode + toString

    public enum FruitType{
    APPLE, PEAR, BANANA, APRICOT;
    }

    public Fruit(FruitType type, double price, int count) {
        Objects.requireNonNull(type, "type не может быть null");
        this.type = type;
        setPrice(price);
        setCount(count);
    }

    public FruitType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0.0) throw new IllegalArgumentException("price может быть только положительное значение, больше 0");
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count <= 0) throw new IllegalArgumentException("count может быть только положительно значение, больше 0");
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit fruit)) return false;
        return Double.compare(fruit.getPrice(), getPrice()) == 0 && getCount() == fruit.getCount() && getType() == fruit.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getPrice(), getCount());
    }

    @Override
    public String toString() {
        return "{"+ getType().toString() +
                ", price: " + getPrice() +
                ", count: " + getCount() + "}";
    }

    public static void main(String[] args) {
        Fruit fruit01 = new Fruit(FruitType.APPLE, 00.01, 2);
        Fruit fruit02 = new Fruit(FruitType.APRICOT, 00.01, 1);
        Fruit fruit03 = new Fruit(FruitType.APRICOT, 00.04, 1);
        Fruit fruit04 = fruit01;
        System.out.println(fruit01.equals(fruit02));
        System.out.println(fruit02.equals(fruit03));
        System.out.println(fruit01.equals(fruit03));
        System.out.println(fruit01.equals(fruit04));
        Comparator<Fruit> byCount = new Fruit.CountComparator();
        Comparator<Fruit> byPrice = new Fruit.PriceComparator();
        System.out.println(byCount.compare(fruit01, fruit02));
        System.out.println(byPrice.compare(fruit03, fruit02));

    }

    public static class CountComparator implements Comparator<Fruit>{
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o1.getCount() - o2.getCount();
        }
    }
    public static class PriceComparator implements Comparator<Fruit> {
        @Override
        public int compare(Fruit one, Fruit two){
            return Double.compare(one.getPrice(), two.getPrice());
        }
    }
}
