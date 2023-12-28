package com.local.project.exam02;

import java.io.*;
import java.util.*;

public class Game {
    private User user;
    private List<User> userList;
    private static Map<String, List<String>> textGame;
    private final File pathToUserList;
    public Game() {
        pathToUserList = new File("C:\\Users\\d9619\\IdeaProjects\\new-local-repository\\" +
                "src\\com\\local\\project\\exam02\\save_archive\\UserList.txt");
        loadUserList();
    }


    public void go(Game game) {
        user = game.registrationUser(game); // ����������� ������
        game.setTextGame();  // �������� ������ � ���������� �������
        user.backToMenu(); // ����� �������� ����
    }

    protected void loadUserList() {  // �������� ������������� �� ����� �������� �����
        this.userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToUserList))) {
            String str;
            while ((str = reader.readLine()) !=null) {
                if(str.isEmpty()) return;
                this.userList.add(new User(this, str));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("������ ������� � ����� " + pathToUserList.getName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("������ �� ����� ������ � ���� " + pathToUserList.getName());
        }
    }

    protected List<User> getUserList() {
        return userList;
    }

    protected void addUserToList(User user) {
        userList.add(user);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToUserList))) {
            for (User u : userList) {
                bufferedWriter.write(u.getLogin() + "\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("������ �� ����� ������ � ��� " + pathToUserList.getName());
        }
    }



    private User registrationUser(Game game) {
        System.out.println("����� ���������� � ���� \"�������\"");
        System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� 2\n");
        System.out.println("1. ����� � ���� ��� ����� �������");
        System.out.println("2. ���������������� ������ ������");
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if (number < 1 || number > 2)
                    System.out.println("\n���������� �����\n");
                else
                    switch (number) {
                        case 1 -> {return user = game.loadUser();}
                        case 2 -> {return user = game.registrationNewUser();}
                    }
            }
            else {
                scanner.next();
                System.out.println("������ �� ���������� ����� ����� �� 1 �� 2\n");
            }
        }
    }

    private User loadUser() {
        System.out.println("���������� ������������������ �������: " + userList.size());
        System.out.println("������ ������������������ �������: " + userList);
        if (userList.isEmpty()) {
            System.out.println("� ���� �� ���������������� ������, �� ������");
            return user = registrationNewUser();
        }
        System.out.println("���� � ���� ��� ����� �������");
        userList = getUserList(); // �������� ������ �������������
        System.out.println("������� Login �� ������ ������������������ ������� ����, �� ������ ��������� �� ����� 10 ��������");
        String login;
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((login = reader.readLine()) != null) {
                if (login.isEmpty()) throw new IllegalArgumentException("login �� ����� ���� ������");
                if (login.length() > 10) throw new IllegalArgumentException("Login ������ ���� �� ����� 10 ��������");
                final String str = login;
                if (userList != null) {
                    boolean loginIsAlreadyRegistered = userList.stream().map(User::getLogin).anyMatch(x -> x.equals(str));
                    if (loginIsAlreadyRegistered) {
                        System.out.println("���� ��������");
                        printStarsSting();
                        user = new User(this, login);
                        return user;
                    } else {
                        System.out.println("������ ������ �� ����������, ���������� ������");
                    }
                } else {
                    System.out.println("� ���� �� ���������������� ������, �� ������");
                    return user = registrationNewUser();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private User registrationNewUser() {
        System.out.println("����������� ������������ ����");
        userList = getUserList(); // �������� ������ �������������
        System.out.println("������� Login, �� ������ ��������� �� ����� 10 ��������");
        String login;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((login = reader.readLine()) != null) {
                if (login.isEmpty()) throw new IllegalArgumentException("login �� ����� ���� ������");
                if (login.length() > 10) throw new IllegalArgumentException("Login ������ ���� �� ����� 10 ��������");
                final String str = login;
                if (userList != null) {
                    boolean loginIsAlreadyRegistered = userList.stream().map(User::getLogin).noneMatch(x -> x.equals(str));
                    if (!loginIsAlreadyRegistered) {
                        System.out.println("Login �����, ���������� ������");
                    } else {
                        setUser(new User(this, login));
                        addUserToList(user);
                        System.out.printf("������������ %s ������� ���������������\n", user);
                        printStarsSting();
                        return user;
                    }
                } else {
                    user = new User(this, login);
                    addUserToList(user);
                    System.out.printf("������������ %s ������� ���������������\n", user);
                    printStarsSting();
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("������ ������ �� �������");
        }
        return null;
    }



    protected User getUser() {
        return user;
    }

    protected void setUser(User user) {
        this.user = user;
    }

    private void setTextGame() {
        System.out.println("\n�������� ���� \"�������\"");
        textGame = new HashMap<>();
        textGame.put("�������", Arrays.asList("������ ���� ������ ����������, ��������� � ��� ��������� � ����������. ��� ���� �� ���� �����������. ������ ������ ��" +
                        " �� ������� ����� �������, �� ��������� ��� �� ����. ������ ����, ����, �� ��� � �� ���� ��������� ������ �����. \"" +
                        "��������� �� ��������� ��� �� ����� �������, ����� �� ����� � ����.\" " +
                        "- ������� ������. ��� ��������� �������?\n",
                "��������� �����",
                "����������� �� ������",
                "����� � ������� ����"));
        textGame.put("��������� �����", Arrays.asList("���������� �����, ������ ����� ��� ���������. ���������, ��� ��������� ������ �� ����� ������� ������ � ������ ��� ���\n" +
                        "������� ����. �� �������� ������������ �� ���� ������, �� ��� �����������. �������-�� ������ ����� ���� �����! ���� " +
                        "����������� �������\n",
                "����� � ������� ����"));
        textGame.put("����������� �� ������", Arrays.asList(
                "��� ������ ������ ���� ������ ������ ������ � �� �������� �������� �� ������ � ��� ��������. �� ����� ��� ������ �����\n" +
                        "���������... ������ �� ����, ��� ��� ������. �������� ���.\n",
                "���������� ��������� � ��������� � ������ �������",
                "������ ��������� � ��������",
                "����� � ������� ����"));
        textGame.put("���������� ��������� � ��������� � ������ �������", Arrays.asList("���� ������ �������� �������, ������ ������ ��������� ��� ����. �������� ������ ���� � ����. �� � ���� ������ ��������\n" +
                        "� �������, � ���� ����� ������ ����������� ��-�� ����������. ���� �������?\n",
                "����������� ����",
                "����������� �����",
                "����� � ������� ����"));
        textGame.put("������ ��������� � ��������", Arrays.asList(
                "������ ������� ����� ������ �� ���� � ������� ����� � ��� �� �������, ��� ����������. ������ ��� ������ ����� ������.\n" +
                        "���� ����������� ��������\n",
                "����� � ������� ����"));
        textGame.put("����������� ����", Arrays.asList(
                "���� ����� �� ������ ��������, �� � ����� �������, ��� ������ ����������� ���������, ��������� ������ ����. ��� ������\n" +
                        "������ �����, ��� � ������� ���� ������, ���� ��������� ���, ��� ������ ����� ������.\n",
                "�������� ���� � ����������� ������ ����",
                "���� �� ����� ������ -> ������ ��������� � ��������",
                "����� � ������� ����"));
        textGame.put("����������� �����", Arrays.asList(
                "���� �������� ������ �����������, �� ������ �� ����. ���� ������, ��� ���������� ������� �� ����� ������� �� ����\n" +
                        "������. � ��� ������ ���������?\n",
                "���� ���� -> ��������� �����",
                "-> ������ ��������� � ��������",
                "����� � ������� ����"));
        textGame.put("�������� ���� � ����������� ������ ����", Arrays.asList(
                "� ������� ���� ������ �������� ����������. ������� ���������� ��� ����� ���������� ���, ��� �����, ���� ������\n" +
                        "������� ��� ���.\n",
                "���, ��������� ������� ����� �������, ����� ���� ������ -> ������ ��������� � ��������",
                "����� ��������������� ������ � ��������� ��",
                "����� � ������� ����"));
        textGame.put("����� ��������������� ������ � ��������� ��", Arrays.asList(
                "������ ������ ����� ��, �� ������ ����� ��� ������� ����. ������ ������ ������ ����, �� � �� ����� ����� �� ����\n" +
                        "������.\n",
                "���������, ����� ����� ������",
                "����� ���������� �������� �� ����������",
                "����� � ������� ����"));
        textGame.put("���������, ����� ����� ������", Arrays.asList(
                "������ �������� �������, � ����� �����������. ������ ��� ������� ������ ���. ����� �� �����, ��� ����� �������. ���\n" +
                        "�� ������?\n",
                "������ ������� � �����������",
                "������ ������� �� ����������",
                "����� � ������� ����"));
        textGame.put("����� ���������� �������� �� ����������", Arrays.asList(
                "��� ���� �� ������ ����. ����� �������� ������, ������ ��� ������ ����� ������. <b>���� ����������� ��������</b>\n",
                "����� � ������� ����"));
        textGame.put("������ ������� � �����������", Arrays.asList(
                "���� ������ ��, ������� ����� ��������� � �������� ���. ������ ����� ������, �� �� ������ ���������� ������. <b>����\n" +
                        "����������� ��������</b>\n",
                "����� � ������� ����"));
        textGame.put("������ ������� �� ����������", Arrays.asList(
                "��������� ���������� ��������� ������, ��� ����� ������ ����� ����� ����� � ������, ��� ��������� ������� �� ����� �� �\n" +
                        "����� ����. �� ������� ������, ��� ����� �� �������� � ������������, � ��� ����� ������ ������, �� ����� ����������\n" +
                        "������ ��������� �����.\n",
                "���������� ������ �� �����, ����� ���������� ������ -> ������ ��������� � ��������",
                "����� ���� �� ���� � ������ ������ �������� -> ��������� �����",
                "����� � ������� ����"));

        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(20);
                System.out.print(".");
            }
            printFox();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("������ �� ����� �����");
        }

        System.out.println("\n���� ���������\n");

    }


    protected void setFirstParagraph() {
        user.setParagraph("�������");
    }

    protected void guessGenerated(String paragraph) {
//        textGame.get(paragraph).stream().forEach(System.out::println); // ����� ����� �� ���� ������� ���. ������ � �������� �������
        for (int i = 0; i < textGame.get(paragraph).size(); i++) {
            if (i == 0) {
                System.out.println(textGame.get(paragraph).get(i));
                System.out.println("�������� �������:");
            } else System.out.printf("%d. %s\n", i, textGame.get(paragraph).get(i));
        }
        int answers = textGame.get(paragraph).size() - 1;
        System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� %d\n", answers);
        Scanner scanner = new Scanner(System.in);
        int number;
        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if (number < 1 || number > answers) {
                System.out.println("\n���������� �����\n");
                guessGenerated(paragraph);
            } else {
                String nextMove = textGame.get(paragraph).get(number);
                printStarsSting();  // �����������
                System.out.printf("\n* ������ ������� ������ �%d - %s *\n", number, nextMove);
                if (nextMove.equals("����� � ������� ����")) {
                    user.backToMenu();
                } else if (nextMove.contains("-> ")) {
                    String[] nextMoves = nextMove.split("-> ");
                    nextMove = nextMoves[1];
                    user.setParagraph(nextMove);   // ���������� �������� ��� ����������� �������� � ����, ��� ����������
                    guessGenerated(nextMove);
                } else {
                    user.setParagraph(nextMove);   // ���������� �������� ��� ����������� �������� � ����, ��� ����������
                    guessGenerated(nextMove);
                }
                return;
            }
        }
    }

    protected void printStarsSting() {
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
            ;
        }
    }

    private void printFox() {
        System.out.println(".\n" +
                "____11________________1___________________________\n" +
                "___����_____________����__________________________\n" +
                "___��_���1_______1���1��__________________________\n" +
                "___��__�������������__��__________________________\n" +
                "___��_1�������������1_��__________________________\n" +
                "____1�������������������__________________________\n" +
                "____�������������������___________________________\n" +
                "____�������������������___________________________\n" +
                "____��������������������__________________________\n" +
                "_____���11����������_���__________________________\n" +
                "____��_�1___�����__1�1_���________________________\n" +
                "____��__1��11����1��___1���1______________________\n" +
                "____��_____�������1____1������1___________________\n" +
                "____��_______11_�______���������__________________\n" +
                "____1�1_______________������������________________\n" +
                "_____��_______________���������������_____________\n" +
                "______1�_____________�����������������1___________\n" +
                "_______1�1_______11_��������������������__________\n" +
                "_________�1_____�������������������������_________\n" +
                "_________��__����������������������������1________\n" +
                "_________�1_��1����__���������������������________\n" +
                "_________�1_��1�����1_���������������������1______\n" +
                "________���_�1�����_��_��������������������1______\n" +
                "________���_�_�����1_��_1�������������������1_____\n" +
                "________���_�_�����1__11_1�������������������_____\n" +
                "________1��_�_�����_��������11����������������____\n" +
                "_______���������������������1�����������������____\n" +
                "_______�����1�����1�������������������1_������____\n" +
                "_____________________________________���������____\n" +
                "______________________�����������������������_____\n" +
                "___________________���1���������������������______\n" +
                "_________________��1__1������������������_________\n" +
                "_________________1��11���������������1____________\n" +
                "____________________1���������1___________________\n"
                );
    }

}


