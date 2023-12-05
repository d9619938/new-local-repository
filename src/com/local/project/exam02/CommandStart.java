package com.local.project.exam02;

public class CommandStart implements Command{
    Menu menu;
    public CommandStart(Menu menu){
        this.menu = menu;
    }
    @Override
    public void execute() {
        menu.startNewGame();
    }
}
