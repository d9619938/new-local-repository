package com.local.project.homeTask10.staticmodifier;

public class GAuth implements Auth{ //Второй вариант авторизации, например через GitHub
    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
