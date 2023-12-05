package com.local.project.lesson27.homeTask27.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfoFile extends Thread{
    private String filename;
    private List<Product> productList;
    public InfoFile (String name, String filename){
        if (name == null && filename != null) throw  new IllegalArgumentException("name and filename not null");
        this.setName(name);
        this.filename = filename;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getFilename() {
        return filename;
    }

    public void run() {
        parseFile();
}

    private void parseFile() {
        String str = null;
        productList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((str = reader.readLine()) != null) {
                String[] parseString = str.split("::");   //
                productList.add(new Product(parseString[0],
                                            parseString[1],
                                            Double.parseDouble(parseString[2]),
                                            Integer.parseInt(parseString[3])));

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка чтения файла");
        }
    }
}
