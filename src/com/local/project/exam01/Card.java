package com.local.project.exam01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Card {

    private static int count;
    private final int NUMBER_OF_CARD; // порядковый номер абонемента
    private final CardType TYPE;         // тип абонемента
    private final LocalDate DATE_START;     // дата начала действия абонемента
    private final LocalDateTime TIME_START;         // время покупки
    private LocalDate dateEnd;  // дата окончания срока действия абонемента
    private LocalDateTime TIME_END;          // время окончания действия
    private final Visitor VISITOR;           // данные гостя


    public Card(CardType type, LocalDate registrationEndDate, Visitor guest) {// конструктор абонемента
        // принимает на вход 1)тип абонемента, 2) дату окончания регистрации, 3) информацию о госте
        this.TYPE = type;
        this.DATE_START = LocalDate.now(); // дата регистрации по дефолту задается как текущая
        this.TIME_START = DATE_START.atTime(LocalTime.now()); // время регистрации берется из даты регистрации
        setDateEnd(registrationEndDate); // окончание действия устанавливаем через сеттер с проверкой типа
        // абонемента
        this.VISITOR = guest;
        this.NUMBER_OF_CARD = ++count;          // задаем порядковый номер абонемента
    }

    public CardType getTYPE() {
        return TYPE;
    }

    public LocalDateTime getTIME_START() {
        return TIME_START;
    }

    public LocalDateTime getTIME_END() {
        return TIME_END;
    }

    public LocalDate getDATE_START() {
        return DATE_START;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public int getNUMBER_OF_CARD() {
        return NUMBER_OF_CARD;
    }
    public Visitor getVISITOR() {return VISITOR;}

    public void setDateEnd(LocalDate dateEnd) {
        if (dateEnd == null || dateEnd.isBefore(DATE_START) || dateEnd.equals(DATE_START)) {
            throw new IllegalArgumentException("введена не корректная дата окончания действия абонемента!");
        } else if (TYPE == CardType.ONE_TIME) { // если тип абонемента "разовый", то устанавливаем
            // дату окончания действия абонемента рег.+1 день
            this.dateEnd = DATE_START.plusDays(1);
        } else {
            this.dateEnd = dateEnd;
        }
        TIME_END = this.dateEnd.atTime(LocalTime.now());
    }

    @Override
    public String toString() {
        return "Информация по абонементу{" +
                "регистрационный номер " + NUMBER_OF_CARD +
                ", тип=" + TYPE +
                ", дата начала действия=" + DATE_START +
                ", дата окончания действия=" + dateEnd +
                ", \nгость=" + VISITOR +
                '}';
    }

}