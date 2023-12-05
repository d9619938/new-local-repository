package com.local.project.exam02;

public class CommandGoToSaveGame implements Command{
    Menu menu;
    public CommandGoToSaveGame(Menu menu) {
        this.menu = menu;
    }
    public void execute() {
        menu.goToSaveGame();
    }
 }
