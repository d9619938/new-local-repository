package com.local.project.homeTask10.clonequals;

import java.util.Objects;

public class Item implements Cloneable{  // extends Object
    private final String name;   // для final нельзя создать getter & setter
    private final double initialPrice;
    private double currentPrice;

    public Item(String name, double price) {
        this.name = name;
        this.initialPrice = price;
        this.currentPrice = price;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", initialPrice=" + initialPrice +
                ", currentPrice=" + currentPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // если сравниваемые объекты ссылаются на один и тот же объект
        if (!(o instanceof Item item)) return false; // если объект не является типом Item, то вернет false
        // далее сравниваются свойства на равенство
        return Double.compare(item.getInitialPrice(), getInitialPrice()) == 0 && Double.compare(item.getCurrentPrice(),
                getCurrentPrice()) == 0 && Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getInitialPrice(), getCurrentPrice());
    }

    @Override
    protected Item /*Object*/ clone() { // тип возвращаемого объекта можно сужать
        try {
            return (Item)super.clone(); // если мы вызываем метод clone родительского класса, то мы обязаны
            // реализовать интерфейс Cloneable в классе Item иначе выпадет ошибка CloneNotSupportedException
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        // clone() создает поверхностную копию объекта, все примитивные значения скопируются, а ссылочные не скопируются!!!
    }
}
