package com.local.project.exam01;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fitnes {

    protected Card[] poolZone = new Card[20];
    protected Card[] gymZone = new Card[20];
    protected Card[] groupClassesZone = new Card[20];
    private final Card[][] allZones = {poolZone, gymZone, groupClassesZone};
    private final String[] zonesName = {"�������", "����������� ���", "��������� �������"};
    private Map<Card[], String> map = new HashMap<>();

    public Fitnes() {
        setMap();
    }

    private void setMap() {
        for (int i = 0; i < allZones.length; i++) {
            map.put(allZones[i], zonesName[i]);
        }
    }

    public void enterTheZone(Card[] zone, Card card) {
        if (zoneAccessCheck(zone, card) && checkingAvailableSeats(zone) && checkDate(card) && checkZone(card)) {
            for (int i = 0; i < zone.length; i++) {
                if (zone[i] == null) {
                    zone[i] = card;
                    System.out.printf("%s %s, ���������� ���� - %s\n", card.getVISITOR().getLastName(), card.getVISITOR().getFirstName(), map.get(zone));
                    System.out.println(LocalDate.now() + " " + LocalTime.now());
                    return;
                }
            }
        }
    }

    public Card[] leaveTheZone(Card[] zone, Card card) {
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] == card)
                zone[i] = null;
            return zone;
        }
        return zone;
    }

    private boolean zoneAccessCheck(Card[] zone, Card card) { // �������� ������� � �������� ����
        boolean isAllowedToVisit = true;
        switch (card.getTYPE()) {
            case ONE_TIME -> {
                if (Arrays.equals(zone, gymZone))
                    System.out.printf("�� ���������� ����� %d (���: %s) ������ �������� ��������� �������\n",
                            card.getNUMBER_OF_CARD(), card.getTYPE());
                isAllowedToVisit = false;
            }
            case DAY -> {
                if (Arrays.equals(zone, poolZone))
                    System.out.printf("�� ���������� ����� %d (���: %s) ������ �������� �������\n",
                            card.getNUMBER_OF_CARD(), card.getTYPE());
                isAllowedToVisit = false;
            }
        }
        return isAllowedToVisit;
    }

    private boolean checkingAvailableSeats(Card[] zone) { // ���� �� ��������� �����?
        int freePlaces = 0;
        for (Card card : zone) {
            if (card == null)
                freePlaces++;
        }
        if (freePlaces == 0) {
            System.out.println("��� ��������� ����");
            return false;
        }
        return true;
    }

    private boolean checkDate(Card card) { // �� ��������� �� ���������
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isAfter(card.getTIME_END())) { // ���� ������� ���� � ����� ������ ���� � �������
            System.out.printf("��������� ����� %d ���������\n", card.getNUMBER_OF_CARD());
            return false;
        } else if (currentTime.toLocalTime().isBefore(LocalTime.of(8, 00))  // ���� ����� ������ 8:00 � ������ 22:00
                || currentTime.toLocalTime().isAfter(LocalTime.of(21, 59))) { //  , �� �� �������
            System.out.println("������ ���� ��� ������, ����� ������ � 08:00 �� 22:00");
            return false;
        } else if (card.getTYPE() == CardType.DAY) {
            if (currentTime.toLocalTime().isBefore(card.getTYPE().getReleaseTime())) { // ������� ����� ������ ������ �� 16 �����
                System.out.println("���� ����� ��������� � 8:00 �� 16:00");
                return false;
            }
        }
        return true;
    }

    private boolean checkZone(Card card) { // �� ��������������� �� ��������� � ����� �� ���?
        for (int i = 0; i < allZones.length; i++) {
            for (int j = 0; j < allZones[i].length; j++) {
                if (allZones[i][j] == card) {
                    System.out.printf("��������� �%d ��� ��������������� � ���� \"%s\" \n", card.getNUMBER_OF_CARD(), zonesName[i]);
                    return false;
                }
            }
        }
        return true;
    }

}

