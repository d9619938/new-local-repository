package com.local.project.exam02;

import java.util.Arrays;

public class CommandBackToMenu implements Command{
    Menu menu;
    public CommandBackToMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.backToMenu();
    }
}
