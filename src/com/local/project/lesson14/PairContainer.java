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
        PairContainer<Number, String> pairContainer01 = new PairContainer<>(0.19f, "������ ����");
        PairContainer<String, UserId<Number>> pairContainer02 = new PairContainer<>("������ ����", new UserId<>(1));
        PairContainer<String, PairContainer<Number, UserId<String>>> pairContainer03 =
                new PairContainer<>("������ ����", new PairContainer<>(39.5, new UserId<>("user")));



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
    // ������: ������ ����� ����� ����� ������� � object ???
    // �����: ����� ������� ������ Cat � ��� ����������, � ����� ������ ����������� Eatable � Serializable
    }

    public static  <T extends Animal & Serializable> void void02(T object){

        // ������: ������ ����� ����� ����� ������� � object ???
        // �����: ����� ������� ������ Animal � ��� ����������, � ����� ������ ���������� Runnable

    }

    public static  <T extends Serializable & Runnable> void void03(T object){
        // ������: ������ ����� ����� ����� ������� � object ???
        // �����: ����� ������� ������ Object, � ����� ������ ���������� Serializable � Runnable

    }

    public static void main(String[] args) {
//        Task.</* ������: ����� ���� ����� ������� ??? */>void01(/* ������: ����� ���� ����� �������� ??? */);
        // �����: ����� ������� Cat � Kitten                                Cat � Kitten

//        Task.</* ������: ����� ���� ����� ������� ??? */>void02(/* ������: ����� ���� ����� �������� ??? */);
        //�����:  ����� ������� Cat, Kitten, Dog                                Cat, Kitten, Dog

//        Task.</* ������: ����� ���� ����� ������� ??? */>void03(/* ������: ����� ���� ����� �������� ??? */);
        //�����:  ����� ������� Cat, Kitten, Dog                                Cat, Kitten, Dog


    }
}