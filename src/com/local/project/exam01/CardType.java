package com.local.project.exam01;

import java.time.LocalDate;
import java.time.LocalTime;

public enum CardType {
    ONE_TIME("Разовый", LocalTime.of(8, 00), LocalTime.of(22, 00)),
    DAY ("Дневной",  LocalTime.of(8, 00), LocalTime.of(16, 00)),
    FULL("Полный", LocalTime.of(8, 00), LocalTime.of(22, 00));

private String name;
private LocalTime entryTime;
private LocalTime releaseTime;

CardType(String name, LocalTime entryTime, LocalTime releaseTime) {
    this.name = name;
    this.entryTime = entryTime;
    this.releaseTime = releaseTime;
}

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public LocalTime getReleaseTime() {
        return releaseTime;
    }

    @Override
    public String toString() {
        return name;
    }
}

