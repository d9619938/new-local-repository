package com.local.project.lesson18;

@FunctionalInterface  // обязательно указывать, чтобы компилятор проверял количество абстрактных методов
public interface Operation {
    double action(double a, double b);
//    double test (double a, double b);
    default Operation addOperation (Operation other){ // дефолтный метод для объединения функционала нескольких операций
        return (a, b) -> action(a, b) + other.action(a, b); // принимает на вход
    }
}
