package com.local.project.exam02;


public class CommandExitGame implements Command{
    Menu menu;

    public CommandExitGame(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void execute() {
        menu.exitGame();
    }
}
