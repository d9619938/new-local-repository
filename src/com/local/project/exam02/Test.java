package com.local.project.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
        System.out.println("попытка 2");
        Test test02 = new Test();
        test02.test();
    }
    public void test () {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                return;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
