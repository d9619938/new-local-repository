package homeTask05;

import java.util.Arrays;

public class Task0501 {
   /* Задача #1
    Объявить массив целых чисел. Длина массива - 15. Заполнить массив четными числами в диапазоне [10, 100).
    Для заполнения массива использовать цикл. */
    public static void main(String[] args) {

        int[] arr = new int[15];
        int min = 10, max = 99;
        System.out.print("верхняя - строка рандомные значения [10, 100) : ");
        for (int i = 0; i < arr.length; i++) {
            int value = (int) (Math.random() * (max-min)) + min;
            System.out.print(value + " ");
            if (value % 2 == 0)
            arr[i] = value;
            else i--;
        }
        System.out.println();
        System.out.printf("\nнижняя строка - массив длинной %d элеменов, " +
                "заполненный четными числами: %s \n", arr.length, Arrays.toString(arr));
    }
}
