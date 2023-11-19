package com.local.project.lesson22.task;


public class DecoratorTask {
    public static void main(String[] args) {
        // AppLogger -регистратор приложений
        // Delimiter - разделитель
        // Upper - верхний
        // ConsoleWriter - писатель в консоль
        // AppFileWriter - приложение для записи файлов
        // log - журнал

        AppLogger logger01 = new Delimiter(new Upper(new ConsoleWriter())); // Регистратор приложений
        logger01.log("сообщение");

        AppLogger logger02 = new Upper(new Delimiter(new AppFileWriter("file.txt")));
        logger02.log("сообщение");


        ConsoleWriter console = new ConsoleWriter();
        console.log("данные"); // данные будут выведены в консоль

        AppFileWriter file = new AppFileWriter("file.txt");
        file.log("данные"); // данные будут записаны в файл

        // Реализовать функционал, используя паттерн Декоратор и исходя из следующих условий:

        /*
        ConsoleWriter (вывод в консоль) и AppFileWriter (запись в файл) - классы с основным функционалом
        Они могут работать самостоятельно
        */

        /*
        `Upper` и `Delimiter` обеспечивают дополнительный функционал,
        их конструктор должен принимать на вход экземпляры классов,
        обеспечивающих дополнительный функционал или экземпляры классов, обеспечивающих основной функционал.
        Создавать цепочку дополнительного функционала можно до тех пор,
        пока в конструктор не будет передан экземпляр основного функционала.
        */

        // В программе возможно появление новых дополнительных и основных классов.

        /*
        Используйте следующий код для записи в файл:
        try {
            Files.writeString(Paths.get("file-name.txt"), "данные", StandardOpenOption.APPEND);
            // "данные" будут записаны в конец (StandardOpenOption.APPEND) файла "file-name.txt"
        } catch (IOException e) {
            System.out.println("Данные не были записаны");
        }
        */

    }
}
