package com.local.project.lesson21.singleton;

import java.io.Serializable;

public class Settings implements Serializable {
    private static Settings settings = new Settings();   // Потокобезопастная инициализация

    private Settings() {
    }

    public static Settings getSettings() {
       /* synchronized (Settings.class){                    Не потокобезопастная инициализация
            if (settings == null) settings = new Settings();
        }
        */ return settings;
    }
/*    public static Settings getSettings() {     Ленивая потокобезопасная инициализация
        if (settings == null) {
            synchronized (Settings.class) {
                if (settings == null) settings = new Settings();
            }
            return settings;
        }
    }*/
}

//САМЫЙ ПРАВИЛЬНЫЙ СПОСОБ СОЗДАТЬ СИНГЛТОН - ЭТО ПЕРЕЧИСЛЕНИЕ ENUM

//enum Settings01 {
//    APP_SETTINGS();
//    private String string;
//    private int anInt;
//}
//Settings01 obj = Settings01.APP_SETTINGS;

//ВОПРОСЫ К САМОСТОЯТЕЛЬНОМУ ИЗУЧЕНИЮ
// когда класс загружается в память?
// когда загружаютс ясупертипы: ?
// родители, интерфейсы, супертипы интерфейсов?
// пул констант, как происходит инициализация статических свойств и конструктора