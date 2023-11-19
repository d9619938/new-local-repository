package com.local.project.lesson22.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppFileWriter implements AppLogger{
    private String str;

    public AppFileWriter(String str) {
        this.str = str;
    }
    @Override
    public void log (String str){
        try {
            Files.writeString(Paths.get("file-name.txt"), str, StandardOpenOption.APPEND);
            // "данные" будут записаны в конец (StandardOpenOption.APPEND) файла "file-name.txt"
        } catch (IOException e) {
            System.out.println("Данные не были записаны");
            e.printStackTrace();
        }

    }
}
