package com.local.project.lesson24.autoclosable;

import java.io.IOException;

public class Lesson24AutoClosable {
    public static void main(String[] args) {
        Resource resource01 = null;
        try {
            resource01 = new Resource();
            resource01.resourceVoid();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (resource01 != null) resource01.close(); // - правильно! с проверкой на null
        }
//        resource01.close(); - не правильно


        // try with resources
        try (Resource resource02 = new Resource()) {
            resource02.resourceVoid();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
