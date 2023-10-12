package homeTask04;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (scanner.hasNextInt() && (number = scanner.nextInt()) >= 0) {
            int sum = 0;
            String line = "" + number;
            char[] charArr = line.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                sum = sum + Character.getNumericValue(charArr[i]);
            }
            System.out.println(sum);
        }
    }
}
// пока длинна числа >=2 выполнять /10 +%10 и сложение обновленного числа - не работет, сбой как раз на двойке
// строку сразу в int[] не добавить...лишние цифры получаются
// деление на 10 в степени длинны и сложение остатков...так и не отладил, до правильной работы

// преобразовал int в String, создал char[] записав в него строку-> через for перебрал индексы char[],
// суммируя их содержимое
