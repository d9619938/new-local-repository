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
������ - ���������� � �������� ���������������, ����� ����������� ���������� ���������.
������ - ���������� � �������� �����������, ���� ������������ ����� ��������� ������ ��������� ���, ���� ������ �������� ��������.
������ - ���������� ��������� ��������� ������ �� ������� ������������ (���� exit � �������) ���, ���� ������ �������� ��������.
������ - ������ � ��������� ������ �������� ������ �� ������������, ������� ��������� Message � ���������� ��������� �� ������.
������ - ������ � ��������� ������ �������� ��������� �� ������� � ������� �� � �������.
������������ ����� ��������� �� ������ '.txt' ����. ����������: �������� ����� (�� ����� N ��������)
� ���������� ����� (�� ����� M Mb). �������� N � M ������ ��������������.
������������ ����� ��������� '.txt' ����, ��� ��������� ����� ������������ ������ ������ ��� ��������.
 �������� � �������� ��������� ������ ��������� ������.*/

public class Client implements Runnable {

    InetSocketAddress remoteAddress;
    private String name;

    {
//            System.out.println("������ ��� ������������, ����� ������� ENTER");
//            Scanner scanner = new Scanner(System.in);
//            name = scanner.nextLine();
    }

    public Client(InetSocketAddress remoteAddress) {
        this.remoteAddress = Objects.requireNonNull(remoteAddress, "remoteAddress �� ����� ���� null");
        name = "CLIENT_nnn";
    }

    public String getName() {
        return name;
    }


    @Override
    public void run() {
        try{
            Socket socket = new Socket(); // ����� ��� ���������� � ��������
            socket.connect(remoteAddress); // �������� � ����� IP � ���� �������
            try {
                ConnectionService service = new ConnectionService(socket); // ���������� ConnectionService ��� ���������
                                                                            // ����������� �������� � ��������� ���������
                System.out.println("���������� � �������� �����������.");
                Thread threadWrithe = new Thread(()-> {   // ��������� ����� ��� �������� ��������� �������� �� ������
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("������ ����� ��������� ��� '/exit' ��� ������.");
                    while (true) {
                        String str;
                        str = scanner.nextLine();
                        if ("/exit".equals(str)) {
                            try {
                                socket.close();
                                System.out.println("�� �������� ���");
                                System.exit(1);
                            } catch (IOException e) {
                                System.out.println("������ �� ����� �������� ������");
                                System.out.println(e.getMessage());
                            }
                        } else {
                            try {
                                service.writheMessage(new Message(
                                        "����� " + name + ": " + str));
                            } catch (IOException e) {
                                System.out.println("������ ����������, ���������� ����������������");
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
                                System.out.println("������ �� ����� ��������� ���������");
                                throw new RuntimeException();
                            }
                    }
                });

                threadWrithe.start();
                threadRead.start();

            } catch (IOException e) {
                System.out.println("������ �������� ��������");
                System.out.println(e.getMessage());
                System.exit(2);
            }

        } catch (IOException e) {
            System.out.println("������ �� ��������, �� ������� ���������� ���������� � ��������.");
            System.out.println(e.getMessage());
        }
    }
}
