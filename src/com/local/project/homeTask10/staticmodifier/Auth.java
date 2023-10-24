package com.local.project.homeTask10.staticmodifier;

public sealed interface Auth permits GAuth, AppAuth{
    boolean login(String username, String password);
    boolean logout();


    static Auth getAuth(String authType) {
        Auth auth; // благодаря общему супертипу интерфейса можно запустить ветвление
//        и потом независимо от типа самой переменной вызвать у нее методы интерфейса
        if (authType.equals("github")) {
            auth = new GAuth();
        } else {
            auth = new AppAuth();
        }
        return auth;
    }

}