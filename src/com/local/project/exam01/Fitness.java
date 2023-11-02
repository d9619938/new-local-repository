package com.local.project.exam01;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Fitness {

    protected Card[] poolZone = new Card[20];
    protected Card[] gymZone = new Card[20];
    protected Card[] groupClassesZone = new Card[20];
    private final Card[][] allZones = {poolZone, gymZone, groupClassesZone};
    private final String[] zonesName = {"бассейн", "тренажерный зал", "групповые занятия"};
    private final Map<Card[], String> map = new HashMap<>();

    public Fitness() {
        setMap();
    }

    private void setMap() {
        for (int i = 0; i < allZones.length; i++) {
            map.put(allZones[i], zonesName[i]);
        }
    }

    protected void enterTheZone(Card[] zone, Card card) {
        // D жизни думаю логичнее сначала проверить на время посещения, т.к. зал может быть вообще зарыт,
        // а после уже на доступ в зону
        // ВНИМАНИЕ: метод checkDate завязан на время посещения с 8:00 до 22:00...либо его закомментировать, либо установить
        // время на компе в диапазон [8:00 ; 22:00)
        if (checkDate(card) && zoneAccessCheck(zone, card) && checkingAvailableSeats(zone) && checkZone(card)) {
            for (int i = 0; i < zone.length; i++) {
                if (zone[i] == null) {
                    zone[i] = card;
                    printInfoOneCard(zone, card);
                    return;
                }
            }
        }
    }

    protected void leaveTheZone(Card[] zone, Card card) { // Выход из зоны клуба
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] == card)
                zone[i] = null;
        }
    }

    private boolean zoneAccessCheck(Card[] zone, Card card) { // проверка доступа в желаемую зону
        boolean isAllowedToVisit = true;
        switch (card.getTYPE()) {
            case ONE_TIME -> {
                /*if (Arrays.equals(zone, groupClassesZone)) {*/ //через Array.equals не верно сравнивает дефолтные массивы
                if (zone == groupClassesZone) {
                    System.out.printf("По абонементу номер %d (тип: %s) нельзя посещать групповые занятья\n",
                            card.getNUMBER_OF_CARD(), card.getTYPE());
                    isAllowedToVisit = false;
                }
            }
            case DAY -> {
                /*if (Arrays.equals(zone, poolZone)) {*/      //через Array.equals не верно сравнивает дефолтные массивы
                if (zone == poolZone) {
                    System.out.printf("По абонементу номер %d (тип: %s) нельзя посещать бассейн\n",
                            card.getNUMBER_OF_CARD(), card.getTYPE());
                    isAllowedToVisit = false;
                }
            }
        }
        return isAllowedToVisit;
    }

    private boolean checkingAvailableSeats(Card[] zone) { // есть ли свободные места?
        int freePlaces = 0;
        for (Card card : zone) {
            if (card == null)
                freePlaces++;
        }
        if (freePlaces == 0) {
            System.out.printf("В зоне \"%s\" нет свободных мест\n", map.get(zone));
            return false;
        }
        return true;
    }

    private boolean checkDate(Card card) { // не просрочен ли абонемент
        // ВНИМАНИЕ: метод checkDate завязан на время посещения с 8:00 до 22:00...либо его закомментировать, либо установить
        // время на компе в диапазон [8:00 ; 22:00)
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isAfter(card.getTIME_END())) { // если текущие дата и время больше даты и времени
            System.out.printf("Абонемент номер %d просрочен\n", card.getNUMBER_OF_CARD());
            return false;
        } else if (currentTime.toLocalTime().isBefore(LocalTime.of(8, 0))  // если время меньше 8:00 и больше 22:00
                || currentTime.toLocalTime().isAfter(LocalTime.of(21, 59))) { //  , то не пускать
            System.out.println("Фитнес клуб еще закрыт, время работы с 08:00 до 22:00");
            return false;
        } else if (card.getTYPE() == CardType.DAY) {
            if (currentTime.toLocalTime().isBefore(card.getTYPE().getReleaseTime())) { // дневной может пройти только до 16 часов
                System.out.println("Ваше время посещения с 8:00 до 16:00");
                return false;
            }
        }
        return true;
    }

    private boolean checkZone(Card card) { // не зарегистрирован ли абонемент в одной из зон?
        for (int i = 0; i < allZones.length; i++) {
            for (int j = 0; j < allZones[i].length; j++) {
                if (allZones[i][j] == card) {
                    System.out.printf("Абонемент №%d уже зарегистрирован в зоне \"%s\" \n",
                            card.getNUMBER_OF_CARD(), zonesName[i]);
                    return false;
                }
            }
        }
        return true;
    }

    private void printInfoOneCard(Card[] zone, Card card) {
        System.out.printf("Абонемент №%d: %s %s, посещаемая зона - %s\n", card.getNUMBER_OF_CARD(),
                card.getVISITOR().getLastName(), card.getVISITOR().getFirstName(), map.get(zone));
        LocalDateTime now = LocalDateTime.now();
        System.out.printf("Дата и время посещения : %s %s:%s:%s\n", now.toLocalDate(), now.getHour(),
                now.getMinute(), now.getSecond());
    }

    protected void printInfoAllCard() {
        for (Card[] all : allZones) {
            System.out.printf("\nВ зоне \"%s\" в текущий момент зарегистрированы:\n", map.get(all));
            for (Card zone : all) {

                System.out.println(zone);
            }

        }
    }
}

