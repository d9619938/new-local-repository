package com.local.project.exam03.server;

import com.local.project.exam03.service.ConnectionService;
import com.local.project.exam03.service.Message;

import java.io.IOException;

public class ConnectionThread implements Runnable {
    Server server;
    ConnectionService connectionService;


    public ConnectionThread(Server server, ConnectionService connectionService) {
        this.server = server;
        this.connectionService = connectionService;
    }

    public void run() {
        while (true) {
            Message message = null;
            try {
                message = connectionService.readMessage();
                System.out.println(message);

                for (ConnectionService connection : server.getConnectionServicesList()) {
                    try {
                        connection.writheMessage(message);
                    } catch (IOException e) {
                        System.out.println("Ошибка отправки сообщения");
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                server.getConnectionServicesList().remove(connectionService);
                for (ConnectionService connection : server.getConnectionServicesList()) {
                    try {
                        connection.writheMessage(new Message("один из пользователей покинул чат"));
                    } catch (IOException ex) {
                        System.out.println("Ошибка отправки сообщения");
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println("Соединение с клиентом разорвано");
                System.out.printf("Количество активных подключений - %d\n", server.getConnectionServicesList().size());
                connectionService.close();
                return;
            }

        }
    }
}
