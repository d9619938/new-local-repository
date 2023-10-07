package HomeTask04;

import java.util.Scanner;

public class GuessTask02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = 1, max = 100;
        int count = 0;
        boolean isRight = false;

        System.out.println("Загадайте число от 1 до 100");
        while (!isRight) {
            int middle = (max + min) / 2;
            count++;
            System.out.println("Число равно " + middle + " ? " +
                    "Вместо текстовых ответов ДА/НЕТ" +
                    ", используйте числа 0 - НЕТ и 1 - ДА. Далее нажмите ENTER");
            if (scanner.hasNextInt()) { // проверка на тип данных
                                        // если true, то запускаем процесс угадывания
                int answer = scanner.nextInt(); // готовим сканнер к следующей строке
                if (answer == 1) {
                    System.out.println("Загаданное число равно " + middle + " кол-во попыток " + count);
                    isRight = true;
                } else {
                    System.out.println("Число больше " + middle + " ? " +
                            "Вместо текстовых ответов ДА/НЕТ" +
                            ", используйте числа 0 - НЕТ и 1 - ДА. Далее нажмите ENTER");
                    if (scanner.hasNext()) {
                        answer = scanner.nextInt();
                        if (answer == 1) {
                            min = ++middle;
                        } else {
                            max = --middle;
                        }
                    } else {
                        scanner.next();
                        System.out.println("ошибка ввода"); // программа не всегда выводит строку,
                                                            // т.к. выбрасывает исключение....подумать!
                        // Закономерность - если изначально сроковый ввод, то исключение не выбрасывается.
                        // Если после числового ввода ввести строку, то выбрасывается.
                    }
                }
            } else {
                scanner.next();// готовим сканнер к следующей строке
                System.out.println("ошибка ввода");
            }
        }
    }
}
