package com.local.project.exam02;

public class CommandBackToGame implements Command {
    Menu menu;

    public CommandBackToGame(Menu menu) {
        this.menu = menu;
    }

    public void execute() {
        menu.backToGame();
    }
}
