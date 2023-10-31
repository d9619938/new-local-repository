package com.local.project.lesson12;

import java.time.LocalDateTime;
// запись - это не полноценный функционал, чаще используется как вложенная запись
// Review - имя записи
// () - заголовок или хедер
// long id, String text, LocalDateTime createdAT - компоненты (это только у записи в круглых скобках)
public record Review(long id, String text, LocalDateTime createdAT) {
    // тело записи

    //внутри можно объявлять только static поля
    //можно написать реализацию канонического (canonical) конструктора
    //public Review(long id, String text, LocalDateTime createdAT) {}
    //или написать реализацию компактного (compact) конструктора
    public Review/*(по умолчанию принимает компоненты записи) */{
        if (id < 0 || (text.trim().length()) < 5 || createdAT == null)
            throw new IllegalArgumentException("Переданы невалидные данные");
        // по умолчанию инициализирует значения всех свойств
    }
    // модификатор конструктора (компактного или канонического) не может быть ниже чем у самой записи Record
    // на остальные конструкторы ограничения по модификаторам нет
    // можно перегрузить конструкторы, но в них нужно вызвать один из объявленных ранее, рекурсивно (перекрестно) вызывать нельзя
    public Review(String text){
        this(0, text);
    }
    public Review(long id, String text) {
        this(id, text, LocalDateTime.now());
    }
    // можно объявлять собственные методы (статические и нет)
    // можно написать собственную логику геттеров, equals, hashCode и toString

    @Override
    public String text() {
        return text.toUpperCase();
    }
}

// не могут наследоваться
// не могут иметь наследников (final)
// могут иметь интерфейсы, в том числе sealed
// могут быть вложенными и могут иметь вложенные типы (записи)
// могут объявляться generic типами

// 1. по умолчанию генерируются private final поля - названия и типы, как у компонентов заголовка
// 2. канонический (canonical) конструктор - принимает и инициализирует значения всех свойств
// 3. одноименные (с полями) геттеры
// 4. equals, hashCode, toString
