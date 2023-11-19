package com.local.project.exam02;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Comic {
    String fileName = "D:\\хрлн\\exam02\\comic.txt";
    Map<String, Map<String, List<String>>> pafagrfMap;


    public List<String> readFile(String fileName) {
        if (fileName == null || !fileName.endsWith(".txt")) throw new IllegalArgumentException("file not null");
        String line;
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void parseLine(String line){
    List <String> paragraf = new ArrayList<>();
    String[] str = line.split("#");
        System.out.println(str);
    }

    public static void main(String[] args) {


        String answer;
        String text = "";
        Comic comic = new Comic();
        Map<Object, List<String>> paragrafMap = new HashMap<>();

        List<String> paragrafText = comic.readFile(comic.fileName).stream()
                .filter(x -> x.startsWith("###"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(paragrafText);


    }
}
