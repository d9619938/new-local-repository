package com.local.project.lesson12;

import java.time.LocalDateTime;
// ������ - ��� �� ����������� ����������, ���� ������������ ��� ��������� ������
// Review - ��� ������
// () - ��������� ��� �����
// long id, String text, LocalDateTime createdAT - ���������� (��� ������ � ������ � ������� �������)
public record Review(long id, String text, LocalDateTime createdAT) {
    // ���� ������

    //������ ����� ��������� ������ static ����
    //����� �������� ���������� ������������� (canonical) ������������
    //public Review(long id, String text, LocalDateTime createdAT) {}
    //��� �������� ���������� ����������� (compact) ������������
    public Review/*(�� ��������� ��������� ���������� ������) */{
        if (id < 0 || (text.trim().length()) < 5 || createdAT == null)
            throw new IllegalArgumentException("�������� ���������� ������");
        // �� ��������� �������������� �������� ���� �������
    }
    // ����������� ������������ (����������� ��� �������������) �� ����� ���� ���� ��� � ����� ������ Record
    // �� ��������� ������������ ����������� �� ������������� ���
    // ����� ����������� ������������, �� � ��� ����� ������� ���� �� ����������� �����, ���������� (�����������) �������� ������
    public Review(String text){
        this(0, text);
    }
    public Review(long id, String text) {
        this(id, text, LocalDateTime.now());
    }
    // ����� ��������� ����������� ������ (����������� � ���)
    // ����� �������� ����������� ������ ��������, equals, hashCode � toString

    @Override
    public String text() {
        return text.toUpperCase();
    }
}

// �� ����� �������������
// �� ����� ����� ����������� (final)
// ����� ����� ����������, � ��� ����� sealed
// ����� ���� ���������� � ����� ����� ��������� ���� (������)
// ����� ����������� generic ������

// 1. �� ��������� ������������ private final ���� - �������� � ����, ��� � ����������� ���������
// 2. ������������ (canonical) ����������� - ��������� � �������������� �������� ���� �������
// 3. ����������� (� ������) �������
// 4. equals, hashCode, toString
