package com.local.project.lesson25;

import java.util.ArrayList;

public class Lesson25 {
    public static void main(String[] args) {
        Rate full = new Rate(1, Rate.RateType.FULL);

        Trader trader = new Trader(1, new ArrayList<>(), full);

        Item item01 = new Item(1, "Стол", 12000, trader);
        Item item02 = new Item(2, "Диван", 78000, trader);
        Item item03 = new Item(3, "Стул", 4500, trader);
        Item item04 = new Item(4, "Люстра", 9300, trader);

        trader.addItem(item01);
        trader.addItem(item02);
        trader.addItem(item03);
        trader.addItem(item04);
    }
}
