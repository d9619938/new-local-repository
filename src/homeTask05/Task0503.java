package homeTask05;

import java.util.Scanner;

public class Task0503 {
    /*
    Задача #3
    Заполните массив на len элементов (размер массива вводит пользователь)
    случайным целыми числами и выведете максимальное, минимальное и среднее арифметическое значение элементов массива.
    */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        int[] arr = new int[value];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        double average = ((double) sum) /arr.length;

        System.out.println("Максимальное число :" + max);
        System.out.println("Минимальное число :" + min);
        System.out.println("Среднеарифметическое значение элементов :" + average);
    }
}