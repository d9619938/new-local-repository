package com.local.project.exam02;

public class CommandSaveGame implements Command {
    Menu menu;
    public CommandSaveGame(Menu menu) {
        this.menu = menu;
    }
    public void execute() {
        menu.saveGame();
    }
}
