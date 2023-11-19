package com.local.project.lesson22.strategy.observer;


import java.util.ArrayList;
import java.util.List;

public class Connection {
    Status status;
    List<Listener> list = new ArrayList<>();

    public void addListener(Listener listener) {
        list.add(listener);
    }
    public void removeListener(Listener listener) {
        list.remove(listener);
    }

}
