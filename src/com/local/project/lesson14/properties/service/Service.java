package com.local.project.lesson14.properties.service;

// в качестве ограничения можно указать один класс и любое количество интерфейсов
// в классе у generic свойства можно вызывать методы указанных типов и их супертипов
public class Service<T> {
    private T element;

    public Service() {
    }

    public Service(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void startRepair(){
        System.out.println(element);
    }
}
