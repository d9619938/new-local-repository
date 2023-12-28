package com.local.project.exam02;

import com.local.project.lesson29.FileFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    private Game game;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public Menu(Game game) {
        if (game == null) throw new IllegalArgumentException("menu not null");
        this.game = game;
    }

    private MenuItems MENU_ITEMS;

    public void startNewGame() {
        game.printStarsSting();
        System.out.println("\n* ������ ���� *");
        game.setFirstParagraph();
        game.guessGenerated(game.getUser().getParagraph());
    }

    public void backToGame() {
        game.printStarsSting();
        System.out.println("\n* ������ ����� - " + MenuItems.BACK_TO_GAME + " *");
        game.guessGenerated(game.getUser().getParagraph());
    }

    public void exitGame() {
        game.printStarsSting();
        System.out.println("\n�� ������� ��� ������ " + MenuItems.EXIT_GAME.toString().toLowerCase() + "?");
        System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� 2\n");
        System.out.println("1. " + MenuItems.EXIT_GAME);
        System.out.println("2. ��������� � �������� ����");
        Scanner scanner = new Scanner(System.in);
        int number;
        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if (number < 1 || number > 2)
                System.out.println("\n���������� �����\n");
            else
                switch (number) {
                    case 1 -> {
                        System.out.println("*** ���� ��������� ***");
                        System.exit(1);
                    }
                    case 2 -> backToMenu();
                }
        }

    }

    public void saveGame() {
        game.printStarsSting();
        System.out.println("\n* ������ ����� - " + MenuItems.SAVE_GAME + " *");
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(game.getUser().getPathUserFile()));
            bufferedWriter.write(game.getUser().getParagraph());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("������ ���������� ����");
        }
        System.out.println("���� ��������� ��� ���������� - " + game.getUser().getParagraph());
        backToMenu();
    }

    public void goToSaveGame() {
        game.printStarsSting();
        System.out.println("\n* ������ ����� - " + MenuItems.GO_TO_SAVE_GAME + " *");

        try {
            bufferedReader = new BufferedReader(new FileReader(game.getUser().getPathUserFile()));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                game.getUser().setParagraph(str);
            }
            System.out.println("�������� �������� - " + game.getUser().getParagraph());
            backToMenu();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("���� �� ������");
            backToMenu();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("������ ������ ����������� ������ ������ �� �����");
        }
    }

    public void backToMenu() {
        System.out.println("\n\n������ ��������� ����:\n");

        AtomicInteger menuLine = new AtomicInteger();
        Scanner scanner = new Scanner(System.in);
        int number;

           // ����� ��� ������������������ �����, ������� �� ����� ������ ����.
        if (game.getUser().getParagraph() == null && !game.getUser().getPathUserFile().exists()) {
            Arrays.stream(MenuItems.values())
                    .filter(x -> !x.equals(MenuItems.BACK_TO_GAME) && !x.equals(MenuItems.SAVE_GAME) && !x.equals(MenuItems.GO_TO_SAVE_GAME))
                    .forEach(x -> System.out.printf("%d. %s\n", menuLine.incrementAndGet(), x));
            System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� %d\n", menuLine.get());
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number < 1 || number > menuLine.get()) {
                    System.out.println("\n���������� �����\n");
                } else {
                    switch (number) {
                        case 1 -> game.getUser().StartGame();
                        case 2 -> game.getUser().exitGame();
                    }
                }
            }


            // ����� ���� � ������ ������� � ���� ����������� ����. ��� ������ ���� ����� ����������.
        }else if (game.getUser().getParagraph() == null && game.getUser().getPathUserFile().exists()) {
            Arrays.stream(MenuItems.values())
                    .filter(x ->
                            !x.equals(MenuItems.BACK_TO_GAME) &&
                            !x.equals(MenuItems.SAVE_GAME)
                    )
                    .forEach(x -> System.out.printf("%d. %s\n", menuLine.incrementAndGet(), x));
            System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� %d\n", menuLine.get());
            while (true) {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number < 1 || number > menuLine.get()) {
                        System.out.println("\n���������� �����\n");
                    } else {
                        switch (number) {
                            case 1 -> game.getUser().StartGame();
                            case 2 -> game.getUser().exitGame();
                            case 3 -> game.getUser().goToSaveGame();
                        }
                    }
                } else {
                    scanner.next();
                    System.out.println("\n���������� �����\n");
                }
            }


            // ����� ���� � ������ ������� � ���� ����������� ����, ���� ��������
        }else if (game.getUser().getParagraph() != null && game.getUser().getPathUserFile().exists()) {
            Arrays.stream(MenuItems.values())
                    .forEach(x -> System.out.printf("%d. %s\n", menuLine.incrementAndGet(), x));
            System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� %d\n", menuLine.get());
            while (true) {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number < 1 || number > menuLine.get()) {
                        System.out.println("\n���������� �����\n");
                    } else {
                        switch (number) {
                            case 1 -> game.getUser().StartGame();
                            case 2 -> game.getUser().beckToGame();
                            case 3 -> game.getUser().exitGame();
                            case 4 -> game.getUser().saveGame();
                            case 5 -> game.getUser().goToSaveGame();
                        }
                    }
                } else {
                    scanner.next();
                    System.out.println("\n���������� �����\n");
                }
            }


            // ����� ���� � ������ �������, �� ���������� ���
        } else if (game.getUser().getParagraph() != null && !game.getUser().getPathUserFile().exists()) {
                Arrays.stream(MenuItems.values())
                        .filter(x-> !x.equals(MenuItems.GO_TO_SAVE_GAME))
                        .forEach(x -> System.out.printf("%d. %s\n", menuLine.incrementAndGet(), x));
                System.out.printf("\n�������� ���� �� ��������� ������� � ������ �� ���������� ����� ����� �� 1 �� %d\n", menuLine.get());
                while (true) {
                    if (scanner.hasNextInt()) {
                        number = scanner.nextInt();
                        if (number < 1 || number > menuLine.get()) {
                            System.out.println("\n���������� �����\n");
                        } else {
                            switch (number) {
                                case 1 -> game.getUser().StartGame();
                                case 2 -> game.getUser().beckToGame();
                                case 3 -> game.getUser().exitGame();
                                case 4 -> game.getUser().saveGame();
                            }
                        }
                    } else {
                        scanner.next();
                        System.out.println("\n���������� �����\n");
                    }
                }
        }
        }
    }
