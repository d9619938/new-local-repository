package com.local.project.exam01;

public class Helper {
    public static boolean isAlfa (String str) {
        return str.chars().allMatch(Character ::isLetter);
    }
}
