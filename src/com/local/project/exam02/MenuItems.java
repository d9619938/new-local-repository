package com.local.project.exam02;

public enum MenuItems {
    START_NEW_GAME("������ ����"),
    BACK_TO_GAME("��������� � ����"),
    EXIT_GAME("����� �� ����"),
    SAVE_GAME("��������� ����"),
    GO_TO_SAVE_GAME("��������� ����");

    private final String name;
    MenuItems(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
