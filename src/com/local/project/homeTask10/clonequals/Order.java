package com.local.project.homeTask10.clonequals;

import java.util.Arrays;

public class Order {
    private final Item[] items;


    public Order(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Arrays.equals(getItems(), order.getItems());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getItems());
    }
    @Override
    public Order clone() { // глубокая копия объекта.
        Item[] items1 = new Item[items.length];
        for (int i = 0; i < items1.length; i++) {
            items1[i] = items[i].clone();
        }
        return new Order(items1);
    }
}
