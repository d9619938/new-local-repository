package com.local.project.lesson12;

import java.time.LocalDateTime;

public class Lesson12Record {
    public static void main(String[] args) {
        Review review = new Review(2, "12345", LocalDateTime.now());
        Review review2 = new Review(3, "12345", LocalDateTime.now());
        Review review3 = new Review(3, "12345");
        Review review4 = new Review("12345");


    }
}
