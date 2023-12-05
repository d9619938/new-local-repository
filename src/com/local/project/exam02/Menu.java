package com.local.project.exam02;

public class Menu {
    private MenuItems MENU_ITEMS;
    public void startNewGame(){
        System.out.println(MenuItems.START_NEW_GAME);
    }
    public void backToGame(){
        System.out.println(MenuItems.BACK_TO_GAME);
    }
    public void exitGame(){
        System.out.println(MenuItems.EXIT_GAME);
    }
    public void saveGame(){
        System.out.println(MenuItems.SAVE_GAME);
    }
    public void goToSaveGame(){
        System.out.println(MenuItems.GO_TO_SAVE_GAME);
    }

}
