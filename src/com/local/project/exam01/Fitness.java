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
    private final String[] zonesName = {"�������", "����������� ���", "��������� �������"};
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
        // D ����� ����� �������� ������� ��������� �� ����� ���������, �.�. ��� ����� ���� ������ �����,
        // � ����� ��� �� ������ � ����
        // ��������: ����� checkDate ������� �� ����� ��������� � 8:00 �� 22:00...���� ��� ����������������, ���� ����������
        // ����� �� ����� � �������� [8:00 ; 22:00)
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

    protected void leaveTheZone(Card[] zone, Card card) { // ����� �� ���� �����
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] == card)
                zone[i] = null;
        }
    }

    private boolean zoneAccessCheck(Card[] zone, Card card) { // �������� ������� � �������� ����
        boolean isAllowedToVisit = true;
        switch (card.getTYPE()) {
            case ONE_TIME -> {
                /*if (Arrays.equals(zone, groupClassesZone)) {*/ //����� Array.equals �� ����� ���������� ��������� �������
                if (zone == groupClassesZone) {
                    System.out.printf("�� ���������� ����� %d (���: %s) ������ �������� ��������� �������\n",
                            card.getNUMBER_OF_CARD(), card.getTYPE());
                    isAllowedToVisit = false;
                }
            }
            case DAY -> {
                /*if (Arrays.equals(zone, poolZone)) {*/      //����� Array.equals �� ����� ���������� ��������� �������
                if (zone == poolZone) {
                    System.out.printf("�� ���������� ����� %d (���: %s) ������ �������� �������\n",
                            card.getNUMBER_OF_CARD(), card.getTYPE());
                    isAllowedToVisit = false;
                }
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
            System.out.printf("� ���� \"%s\" ��� ��������� ����\n", map.get(zone));
            return false;
        }
        return true;
    }

    private boolean checkDate(Card card) { // �� ��������� �� ���������
        // ��������: ����� checkDate ������� �� ����� ��������� � 8:00 �� 22:00...���� ��� ����������������, ���� ����������
        // ����� �� ����� � �������� [8:00 ; 22:00)
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isAfter(card.getTIME_END())) { // ���� ������� ���� � ����� ������ ���� � �������
            System.out.printf("��������� ����� %d ���������\n", card.getNUMBER_OF_CARD());
            return false;
        } else if (currentTime.toLocalTime().isBefore(LocalTime.of(8, 0))  // ���� ����� ������ 8:00 � ������ 22:00
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
                    System.out.printf("��������� �%d ��� ��������������� � ���� \"%s\" \n",
                            card.getNUMBER_OF_CARD(), zonesName[i]);
                    return false;
                }
            }
        }
        return true;
    }

    private void printInfoOneCard(Card[] zone, Card card) {
        System.out.printf("��������� �%d: %s %s, ���������� ���� - %s\n", card.getNUMBER_OF_CARD(),
                card.getVISITOR().getLastName(), card.getVISITOR().getFirstName(), map.get(zone));
        LocalDateTime now = LocalDateTime.now();
        System.out.printf("���� � ����� ��������� : %s %s:%s:%s\n", now.toLocalDate(), now.getHour(),
                now.getMinute(), now.getSecond());
    }

    protected void printInfoAllCard() {
        for (Card[] all : allZones) {
            System.out.printf("\n� ���� \"%s\" � ������� ������ ����������������:\n", map.get(all));
            for (Card zone : all) {

                System.out.println(zone);
            }

        }
    }
}

