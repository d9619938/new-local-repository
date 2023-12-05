package com.local.project.exam02;

public class User {

    private String login;
    private String paragraph = "Лисенок";
    Command startGame;
    Command backToGame;
    Command exitGame;
    Command saveGame;
    Command goToSaveGame;

    public User(String login){
        Menu menu = new Menu();
        setLogin(login);
        startGame = new CommandStart(menu);
        backToGame = new CommandBackToGame(menu);
        exitGame = new CommandExitGame(menu);
        saveGame = new CommandSaveGame(menu);
        goToSaveGame = new CommandGoToSaveGame(menu);
    }

    public void setLogin(String login){
            this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public String getParagraph()
    {
       return paragraph;
    }
    void StartGame(){
        startGame.execute();
    }
    void beckToGame(){
        backToGame.execute();
    }
    void exitGame(){
        exitGame.execute();
    }
    void saveGame(){
        saveGame.execute();
    }
    void GoToSaveGame(){
        goToSaveGame.execute();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                '}';
    }
}
