package com.local.project.lesson22.task;

public class Delimiter extends OptionalService {
    public Delimiter(AppLogger logger) {
        super(logger);
    }
    @Override
    public void log(String str){
        // ������������� � �������� ������ ������
        super.log("====" + str + "====");
    }
}
