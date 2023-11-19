package com.local.project.lesson19.nullsafe;

import java.util.Optional;

public class NullSafe19 {
    public static void main(String[] args) {
        // Optional<T> - null-safe ���������,
        // ������� ����� ��������� ������ �� ��������� T ������ ��� null ������

        String name = "Tom";

        // �������� �������

        // 1. ���� name == null, ����� ��������� ����������
        Optional<String> optional01 = Optional.of(name);

        // 2. ���� name == null, ����� ������ ��������� � null �������
        Optional<String> optional02 = Optional.ofNullable(name);

        // 3. ������� ��������� � null �������
        Optional<String> optional03 = Optional.empty();

        // ��������

        if (optional02.isEmpty()) {
            System.out.println("��������� �������� null ������");
        }

        if (optional02.isPresent()) {
            System.out.println("��������� �� �������� null ������");
        }

        // ��������� �������� ��� ����� Optional

        // 1. ���� ��������� �������� null ������, ����� ��������� ����������
        String get = optional02.get();

        // 2. ���� ��������� �������� null ������, ����� ������ �������� ��-���������.
        // ������, ���������� � �����, ����� ������ � ����� ������
        String orElse = optional02.orElse("default");

        // 3. ���� ��������� �������� null ������, ����� ������ �������� ��-��������� �
        // ������, ���������� � �����, �� ����� ������
        String orElseGet = optional02.orElseGet(() -> "default");

        // 4. ������ �������� ��� �������� ����������, ���� � ���������� null ������
        String value01 = optional02.orElseThrow();

        // 5. ������ �������� ��� �������� ����������, ���� � ���������� null ������
        String value02 = optional02.orElseThrow(() ->
                new IllegalArgumentException("null � ����������"));

        // 6. ������ Optional �� ������� �� �������� �� optional02,
        // ���� ��� ������������� ������� value.length() < 10,
        // � ��������� ������ ������ Optional � null �������
        Optional<String> filter = optional02.filter(value -> value.length() < 10);

        // 7. ������ Optional �� ���������, ������� ���������� ����� apply ���������� Function
        // ��� ��������� � null �������, ���� optional02 �������� null ������
        Optional<Integer> map = optional02.map(value -> value.length());

        // 8. ������ Optional �� ��������� numberOptional ��� ����� Optional ���������
        int percent = 10;
        Optional<Number> numberOptional = Optional.ofNullable(percent);
        Optional<Number> or = numberOptional.or(() -> Optional.of(1.1));

        // ���������� ����������, � ����������� �� �����������

        // 1. ����������, ���� optional02 �� �������� null ������
        optional02.ifPresent(value -> System.out.println(value.toUpperCase()));

        // 2.
        optional02.ifPresentOrElse(
                // ����������, ���� optional02 �� �������� null ������
                value -> System.out.println(value.toUpperCase()),
                // ����������, ���� optional02 �������� null ������
                () -> System.out.println("�������� �� ����������")
        );

    }
}