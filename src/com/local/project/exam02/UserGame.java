package com.local.project.exam02;

public class UserGame {
    String login;
    public UserGame(String login){
        if (login == null) throw new IllegalArgumentException("login not null");
        this.login = login;
    }
}
