package com.local.project.lesson22.task;

public class Upper extends OptionalService{
    public Upper(AppLogger logger) {
        super(logger);
    }
    @Override
    public void log (String str) {
        super.log(str.toUpperCase());
    }
}
