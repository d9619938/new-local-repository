package com.local.project.exam03.service;

import com.local.project.exam03.server.Server;

import java.io.Serializable;
import java.time.ZonedDateTime;


public class Message implements Serializable {
    private final String text;
    private ZonedDateTime sentAT;

    public Message(String text) {
        this.text = text;
    }
    public void setSentAt (ZonedDateTime zonedDateTime) {
        this.sentAT = zonedDateTime;
    }


    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "'" + text + "'\n" + "время отправки " + sentAT;
    }
}
