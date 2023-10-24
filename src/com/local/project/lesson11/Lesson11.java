package com.local.project.lesson11;

import java.util.Arrays;

public class Lesson11 {
    public static void main(String[] args) {
        County france = County.FRANCE;  // обращение к перечислению - типОбъекта.ОБЪЕКТ
        Article article = new Article(County.ITALY);
        // сравнивать перечисления можно через ==
        System.out.println(france == article.getCounty());
        // реализация аналогична сравнению через ==
        System.out.println(france.equals(article.getCounty()));

        County[] counties = County.values(); //Country[FRANCE, USA, ITALY] ВСЕГДА в порядке объявления, изменение не доступно
        for (County c : counties){
            System.out.println(c);
        }
        System.out.println(Arrays.toString(counties));
      //  System.out.println(france);
        System.out.println(County.USA.ordinal()); // вернуть элемент массива


        County.ITALY.setName("Италия");
        County.FRANCE.setName("Франция");


    }
}
