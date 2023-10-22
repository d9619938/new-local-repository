package com.local.project.homeTask10;

import com.local.project.homeTask10.clonequals.*;
import com.local.project.homeTask10.staticmodifier.AppAuth;
import com.local.project.homeTask10.staticmodifier.Auth;
import com.local.project.homeTask10.staticmodifier.GAuth;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson10 {
    public static void main(String[] args) {

        Item item01 = new Item("Карандаш", 320);
        Item item02 = new Item("Карандаш", 320);
        System.out.println(item01.toString());
//        System.out.println(item01 == item02); // false
//        System.out.println(item01.equals(item02)); // объекты сравниваются через equals
//                                                    по умолчанию сравнивая ссылки

        //Массивы сравниваются по Arrays.equals
        System.out.println(Arrays.equals(new Item[]{item01, item02}, new Item[] {item02, item01, item02}));

        // Item item03 = new Item("Ручка", 490);
        Order order01 = new Order(new Item[]{item01, item02});
        Order order02 = new Order(new Item[]{item01, item02});
        // order.getItems()[0] = item03;
        Order copy = order01.clone();
        System.out.println(copy == order01); // false
        System.out.println(copy.getItems() == order01.getItems()); // true

        Scanner scanner = new Scanner(System.in);
        System.out.println("имя пользователя");
        String username = scanner.nextLine();

        System.out.println("пароль");
        String pasword = scanner.nextLine();

        System.out.println("Способ авторизации");
        String authType = scanner.nextLine(); // github, app
        Auth auth; // благодаря общему супертипу интерфейса можно запустить ветвление
//        и потом независимо от типа самой переменной вызвать у нее методы интерфейса
        if (authType.equals("github")) {
            auth = new GAuth();
        } else {
            auth = new AppAuth();
        }
        auth.login(username, pasword);

    }
}
