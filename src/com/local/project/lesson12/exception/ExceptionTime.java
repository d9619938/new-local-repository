package com.local.project.lesson12.exception;

import javax.management.ReflectionException;

public class ExceptionTime extends Exception {
    String name;
    public ExceptionTime(Exception e) {
        super(e);
    }

    public ExceptionTime(Exception e, String message) {
        super(message, e);
    }

    public ExceptionTime(String hello) {
    }
}
