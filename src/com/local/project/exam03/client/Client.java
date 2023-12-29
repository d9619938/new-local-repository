package com.local.project.exam03.client;

import com.local.project.exam03.service.ConnectionService;
import com.local.project.exam03.service.Message;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

 /*
Соединение с сервером устанавливается, когда запускается клиентская программа.
Соединение с сервером разрывается, если пользователь решил завершить работу программы или, если сервер перестал отвечать.
Клиентская программа завершает работу по желанию пользователя (ввод exit в консоль) или, если сервер перестал отвечать.
Клиент в отдельном потоке получает данные от пользователя, создает экземпляр Message и отправляет сообщение на сервер.
Клиент в отдельном потоке получает сообщения от сервера и выводит их в консоль.
Пользователь может загрузить на сервер '.txt' файл. Передаются: описание файла (не более N символов) и содержимое файла (не более M Mb). Значения N и M задать самостоятельно.
Пользователь может запросить '.txt' файл, для получения файла пользователь должен ввести его название. Названия и описание доступных файлов присылает сервер.*/

public class Client implements Runnable {

    InetSocketAddress remoteAddress;
    private String name;

    {
//            System.out.println("Введите имя пользователя, после нажмите на ENTER");
//            Scanner scanner = new Scanner(System.in);
//            name = scanner.nextLine();
    }

    public Client(InetSocketAddress remoteAddress) {
        this.remoteAddress = Objects.requireNonNull(remoteAddress, "remoteAddress не может быть null");
        name = "CLIENT_nnn";
    }

    public String getName() {
        return name;
    }


    @Override
    public void run() {
        try{
            Socket socket = new Socket(); // сокет для соединения с сервером
            socket.connect(remoteAddress); // передаем в сокет ip и порт сервера, к которому хотим подключиться
            try {
                ConnectionService service = new ConnectionService(socket); // используем ConnectionService для получения
                                                                            // функционала отправки и получения сообщений
                System.out.println("Соединение с сервером установлено");
                Thread threadWrithe = new Thread(()-> {   // отдельный поток для отправки сообщений на сервер
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите тект сообщения или '/exit' для выхода из чата.");
                    while (true) {
                        String str;
                        str = scanner.nextLine();
                        if ("/exit".equals(str)) {
                            try {
                                socket.close();
                                System.out.println("Вы покинули чат");
                                System.exit(1);
                            } catch (IOException e) {
                                System.out.println("Ошибка во время закрытия сокета");
                                System.out.println(e.getMessage());
                            }
                        } else {
                            try {
                                service.writheMessage(new Message(
                                        "Пишет " + name + ": " + str));
                            } catch (IOException e) {
                                System.out.println("Ошибка соединения, необходимо переподключиться");
                                throw new RuntimeException();
                            }
                        }
                    }
                });

                Thread threadRead = new Thread(()-> {
                    Message message;
                    while (true) {
                            try {
                                message = service.readMessage();
                                System.out.println(message);
                            } catch (IOException e) {
                                    System.out.println("Ошибка во время получения сообщения");
                                    throw new RuntimeException();

                            }
                    }
                });

                threadWrithe.start();
                threadRead.start();

            } catch (IOException e) {
                System.out.println("Сервер перестал отвечать");
                System.out.println(e.getMessage());
                System.exit(2);
            }

        } catch (IOException e) {
            System.out.println("Сервер недоступен, не удалось установить соединение с сервером");
            System.out.println(e.getMessage());
        }
    }
}
