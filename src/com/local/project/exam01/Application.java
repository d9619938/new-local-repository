package com.local.project.exam01;

import java.util.ArrayList;

public class Application {
        public static void main(String[] args) {

            Fitness fitness = new Fitness();
            fitness.printInfoAllCard();  // ������� ��������� ��������, �� ��������, ��� � ��� ���� - "null"

                ArrayList<Card> cards = new ArrayList<>();
            // ������� ����������. ����� generateCard ���������� �����������, ����� (�����) �� ���������� ������ �����.
            // ���� �����������/������������� ��������� ������ ��������� Card, �� ������ ����� �������.
                for (int i = 0; i < 80; i++) {
                                cards.add(Helper.generateCard());
                                System.out.println(cards.get(i));
                }

            for (Card card : cards) {  // �������� ����� �������� � ���� �����
                fitness.enterTheZone(fitness.poolZone, card);
                fitness.enterTheZone(fitness.gymZone, card);
                fitness.enterTheZone(fitness.groupClassesZone, card);
            }

            fitness.printInfoAllCard(); // ���������, ��� ��������� � ����� � ������ ������
            fitness.leaveTheZone(fitness.poolZone, cards.get(1)); // ���������� ������� �� ����
            fitness.printInfoAllCard(); // ���������, ��� ��������� � ����� � ������ ������

        }
}
