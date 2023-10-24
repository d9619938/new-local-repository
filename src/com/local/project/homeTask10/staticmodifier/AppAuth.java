package com.local.project.homeTask10.staticmodifier;

public non-sealed class AppAuth implements Auth{ // обычная авторизация
    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
