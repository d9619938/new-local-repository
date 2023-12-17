package com.local.project.exam03.server;

import com.local.project.exam03.service.ConnectionService;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLOutput;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Готово - Сервер не разрывает соединение с клиентом по своей инициативе.
Готово - Соединение с клиентом разрывается, если клиент перестал отвечать.
Готово - Сервер принимает сообщения от клиентов и рассылает их по всем активным соединениям.
Готово - Каждое соединение клиент-сервер должно обрабатываться в отдельном потоке.
Готово - Активные соединения хранить в потокобезопасной коллекции или мапе.
Если клиент присылает файл и он удовлетворяет всем требованиям, сервер сохраняет его и рассылает остальным клиентам
информацию о том, что загружен новый файл. Сервер рассылает название файла + описание содержимого.
Если клиент запрашивает файл, сервер сначала присылает список имен файлов, потом содержимое выбранного из списка файла.*/

public class Server implements Runnable{

    private final int port;
    private ExecutorService threadPool;
    private CopyOnWriteArrayList<ConnectionService> connectionServicesList;

    public Server(int port) {
        this.port = port;
        threadPool = Executors.newFixedThreadPool(10);
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
    public CopyOnWriteArrayList<ConnectionService> getConnectionServicesList() {
        return connectionServicesList;
    }

    @Override
    public void run() {
     try(ServerSocket serverSocket = new ServerSocket(port)) {
         connectionServicesList = new CopyOnWriteArrayList<>();
         System.out.println("Сервер запущен");
         System.out.printf("Количество активных подключений - %d\n", getConnectionServicesList().size());

         while (true) {
             try {
                 ConnectionService connectionService = new ConnectionService(serverSocket.accept());
                 connectionServicesList.add(connectionService);
                 System.out.println("Новое подключение");
                 System.out.printf("Количество активных подключений - %d\n", getConnectionServicesList().size());
                 threadPool.execute(new ConnectionThread(this, connectionService));
             } catch (IOException e){
                 System.out.println("Ошибка подключения");
                 System.out.println(e.getMessage());
             }
         }

     } catch (IOException e) {
         System.out.println("Ошибка создания serverSocket, возможно порт уже занят");
         System.out.println(e.getMessage());
     }

    }
}
