package com.local.project.lesson21.singleton;

import java.io.Serializable;

public class Settings implements Serializable {
    private static Settings settings = new Settings();   // ����������������� �������������

    private Settings() {
    }

    public static Settings getSettings() {
       /* synchronized (Settings.class){                    �� ����������������� �������������
            if (settings == null) settings = new Settings();
        }
        */ return settings;
    }
/*    public static Settings getSettings() {     ������� ���������������� �������������
        if (settings == null) {
            synchronized (Settings.class) {
                if (settings == null) settings = new Settings();
            }
            return settings;
        }
    }*/
}

//����� ���������� ������ ������� �������� - ��� ������������ ENUM

//enum Settings01 {
//    APP_SETTINGS();
//    private String string;
//    private int anInt;
//}
//Settings01 obj = Settings01.APP_SETTINGS;

//������� � ���������������� ��������
// ����� ����� ����������� � ������?
// ����� ���������� ����������: ?
// ��������, ����������, ��������� �����������?
// ��� ��������, ��� ���������� ������������� ����������� ������� � ������������