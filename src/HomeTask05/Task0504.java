package HomeTask05;

import javax.naming.Name;

public class Task0504 {
    /*
    Задача #4 *
    Дан массив целых чисел: int[] task04 = {88, 34, 12, 55, 90, 4, 10, 44}.
    Найти максимальную сумму четырёх смежных целых чисел в массиве task04.
    Использовать алгоритм скользящего окна.*/


//    Если я правильно понял алгоритм скользящего окна, то его стартовое положение равно 0 (или заданному значению),
//    а закрывающая рамка окна должна скользить по массиву данных и при достижении заданного результата,
//    переходить к следующему шагу, сдвигая стартовую рамку окна согласно условий. После процесс повторяется до
//

    public static void main(String[] args) {
        int[] task04 = {88, 34, 12, 55, 90, 4, 10, 44};
        int searchParameter = 4;
        int sum = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;

        while (end <= task04.length) {
            if (end - start < searchParameter) {
                sum += task04[end];
                end++;
            } else {
                maxSum = Math.max(sum, maxSum);
                System.out.println("Сумма 4-х смежных чисел массива от индекса " + start +
                        " до индекса " + (end-1) + " :" + sum);
                if (end == task04.length) {
                    break;
                }
                    sum = 0;
                    start++;
                    end = start;

            }
        }
        System.out.println("Максимальная сумма смежных чисел :" + maxSum);
    }
}

