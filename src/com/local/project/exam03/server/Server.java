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
������ - ������ �� ��������� ���������� � �������� �� ����� ����������.
������ - ���������� � �������� �����������, ���� ������ �������� ��������.
������ - ������ ��������� ��������� �� �������� � ��������� �� �� ���� �������� �����������.
������ - ������ ���������� ������-������ ������ �������������� � ��������� ������.
������ - �������� ���������� ������� � ���������������� ��������� ��� ����.
���� ������ ��������� ���� � �� ������������� ���� �����������, ������ ��������� ��� � ��������� ��������� ��������
���������� � ���, ��� �������� ����� ����. ������ ��������� �������� ����� + �������� �����������.
���� ������ ����������� ����, ������ ������� ��������� ������ ���� ������, ����� ���������� ���������� �� ������ �����.*/

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
         System.out.println("������ �������");
         System.out.printf("���������� �������� ����������� - %d\n", getConnectionServicesList().size());

         while (true) {
             try {
                 ConnectionService connectionService = new ConnectionService(serverSocket.accept());
                 connectionServicesList.add(connectionService);
                 System.out.println("����� �����������");
                 System.out.printf("���������� �������� ����������� - %d\n", getConnectionServicesList().size());
                 threadPool.execute(new ConnectionThread(this, connectionService));
             } catch (IOException e){
                 System.out.println("������ �����������");
                 System.out.println(e.getMessage());
             }
         }

     } catch (IOException e) {
         System.out.println("������ �������� serverSocket, �������� ���� ��� �����");
         System.out.println(e.getMessage());
     }

    }
}
