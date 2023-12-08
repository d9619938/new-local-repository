package com.local.project.lesson28;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductReader extends Thread{
    private volatile List<Product> products;
    private File file;

    public ProductReader(List<Product> products, File file) {
        this.products = products;
        this.file = file; // Product in file - name::
    }

    @Override
    public void run() {
        List<Product> list = getProductsFromFile(); // сначала обработали данные, получили
        synchronized (products) { // потом захватили объект!!!
            products.addAll(list);
            System.out.println(products);
        }


    }

    private List<Product> getProductsFromFile() {
        try (Stream<String> stringStream = Files.lines(file.toPath())) {
    return stringStream.map(string -> {
       String[] strings = string.split("::") ;
       return new Product(
               strings[0],
               Integer.parseInt(strings[1]),
               Integer.parseInt(strings[2]));
    }).collect(Collectors.toList());
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
}
