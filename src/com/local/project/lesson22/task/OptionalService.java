package com.local.project.lesson22.task;

abstract public class OptionalService implements AppLogger{
    AppLogger logger;
//    private String str;
    public OptionalService(AppLogger logger) {
        if (logger == null) throw new IllegalArgumentException("logger not null");
        this.logger = logger;
    }

    public void log(String str) {
         logger.log(str);
    }
}
