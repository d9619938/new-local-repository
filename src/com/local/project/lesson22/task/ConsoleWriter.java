package com.local.project.lesson22.task;

public class ConsoleWriter implements AppLogger{

    @Override
    public void log(String str) {
        System.out.println(str);
    }
}
