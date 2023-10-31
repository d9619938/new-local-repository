package com.local.project.lesson14;

import java.io.Serializable;

public class PairContainer <K, V> {
    private K key;
    private V value;
    public PairContainer(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        PairContainer<Number, String> pairContainer01 = new PairContainer<>(0.19f, "первая пара");
        PairContainer<String, UserId<Number>> pairContainer02 = new PairContainer<>("вторая пара", new UserId<>(1));
        PairContainer<String, PairContainer<Number, UserId<String>>> pairContainer03 =
                new PairContainer<>("третья пара", new PairContainer<>(39.5, new UserId<>("user")));



    }
}

interface Eatable extends Serializable {}
interface Runnable {}

class Animal implements Runnable{}

class Cat extends Animal implements Eatable{}
class Kitten extends Cat{}

class Dog extends Animal implements Serializable{}


class Task {
    public static  <T extends Cat & Eatable> void void01(T object){
    // ВОПРОС: методы каких типов можно вызвать у object ???
    // ОТВЕТ: можно вызвать методы Cat и его супертипов, а также методы интерфейсов Eatable и Serializable
    }

    public static  <T extends Animal & Serializable> void void02(T object){

        // ВОПРОС: методы каких типов можно вызвать у object ???
        // ОТВЕТ: можно вызвать методы Animal и его супертипов, а также методы интерфейса Runnable

    }

    public static  <T extends Serializable & Runnable> void void03(T object){
        // ВОПРОС: методы каких типов можно вызвать у object ???
        // ОТВЕТ: можно вызвать методы Object, а также методы интерфейса Serializable и Runnable

    }

    public static void main(String[] args) {
//        Task.</* ВОПРОС: какие типы можно указать ??? */>void01(/* ВОПРОС: какие типы можно передать ??? */);
        // ОТВЕТ: Можно указать Cat и Kitten                                Cat и Kitten

//        Task.</* ВОПРОС: какие типы можно указать ??? */>void02(/* ВОПРОС: какие типы можно передать ??? */);
        //ОТВЕТ:  Можно указать Cat, Kitten, Dog                                Cat, Kitten, Dog

//        Task.</* ВОПРОС: какие типы можно указать ??? */>void03(/* ВОПРОС: какие типы можно передать ??? */);
        //ОТВЕТ:  Можно указать Cat, Kitten, Dog                                Cat, Kitten, Dog


    }
}