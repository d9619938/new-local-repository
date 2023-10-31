package com.local.project.exam01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Card {
    /*������ ��������� ������ �����, ���� ����������� (������� ����)
     � ���� ��������� �����������. ������ ��������� ������ ����������
      � ��������� (�� ��������). ������ � ���������: ���, �������,
       ��� ��������.*/
    private static int count;
    private final int NUMBER_OF_CARD; // ���������� ����� ����������
    private final CardType TYPE;         // ��� ����������
    private final LocalDate DATE_START;     // ���� ������ �������� ����������
    private final LocalDateTime TIME_START;         // ����� �������
    private LocalDate dateEnd;  // ���� ��������� ����� �������� ����������
    private LocalDateTime TIME_END;          // ����� ��������� ��������
    private final Visitor VISITOR;           // ������ �����
    private String zoneInfo = "";


    public Card(CardType type, LocalDate registrationEndDate, Visitor guest) {// ����������� ����������
        // ��������� �� ���� 1)��� ����������, 2) ���� ��������� �����������, 3) ���������� � �����
        this.TYPE = type;
        this.DATE_START = LocalDate.now(); // ���� ����������� �� ������� �������� ��� �������
        this.TIME_START = DATE_START.atTime(LocalTime.now()); // ����� ����������� ������� �� ���� �����������
        setDateEnd(registrationEndDate); // ��������� �������� ������������� ����� ������ � ��������� ����
        // ����������
        this.VISITOR = guest;
        this.NUMBER_OF_CARD = ++count;          // ������ ���������� ����� ����������
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
            throw new IllegalArgumentException("������� �� ���������� ���� ��������� �������� ����������!");
        } else if (TYPE == CardType.ONE_TIME) { // ���� ��� ���������� "�������", �� �������������
            // ���� ��������� �������� ���������� ���.+1 ����
            this.dateEnd = DATE_START.plusDays(1);
        } else {
            this.dateEnd = dateEnd;
        }
        TIME_END = this.dateEnd.atTime(LocalTime.now());
    }

    @Override
    public String toString() {
        return "���������� �� ����������{" +
                "��������������� ����� " + NUMBER_OF_CARD +
                ", ���=" + TYPE +
                ", ���� ������ ��������=" + DATE_START +
                ", ���� ��������� ��������=" + dateEnd +
                ", \n�����=" + VISITOR +
                '}';
    }

}

