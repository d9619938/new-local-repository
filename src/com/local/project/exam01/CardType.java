package com.local.project.exam01;

import java.time.LocalTime;

public enum CardType {
    ONE_TIME("Разовый", LocalTime.of(8,0), LocalTime.of(22,0)),
    DAY ("Дневной",  LocalTime.of(8,0), LocalTime.of(16,0)),
    FULL("Полный", LocalTime.of(8,0), LocalTime.of(22,0));

private final String name;
private final LocalTime entryTime;
private final LocalTime releaseTime;

CardType(String name, LocalTime entryTime, LocalTime releaseTime) {
    this.name = name;
    this.entryTime = entryTime;
    this.releaseTime = releaseTime;
}

    public LocalTime getEntryTime() { //
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

