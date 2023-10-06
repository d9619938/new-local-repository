package HomeTask03;

import java.util.Random;

public class ControlFlowStatements {
    public static void main(String[] args) {
        //--------------------------Задача 1-----------------------------------------//

        int min = 10, max = 500;
        int startOfInterval = 25, endOfInterval = 200;
        int result = min + (int) (Math.random() * ((++max) - min));
        if (result < startOfInterval || result > endOfInterval)
            System.out.printf("Число %d не содержится в интервале (%d;%d)\n", result, startOfInterval, endOfInterval);
        else
            System.out.printf("Число %d содержится в интервале (%d;%d)\n", result, startOfInterval, endOfInterval);

        //--------------------------Задача 2-----------------------------------------////

        int currentScoreValue = (int) (Math.random() * 101) + 1;
        if (currentScoreValue >= 90) {
            System.out.println("Пользователь занял первое место");
        } else if (currentScoreValue >= 80) {
            System.out.println("Пользователь занял второе место");
        } else if (currentScoreValue >= 70) {
            System.out.println("Пользователь занял третье место");
        } else {
            System.out.println("Пользователь не зянял призовое место");
        }

        //--------------------------Задача 3-----------------------------------------//


        int x = -5, y = 3;
        if (x > 0 && y > 0) System.out.println("точка принадлежит 1-й четверти");
        else if (x < 0 && y > 0) System.out.println("точка принадлежит 2-й четверти");
        else if (x < 0 && y < 0) System.out.println("точка принадлежит 3-й четверти");
        else if (x > 0 && y < 0) System.out.println("точка принадлежит 4-й четверти");

        //--------------------------Задача 4-----------------------------------------//

        Random random = new Random();
        boolean isLeap = random.nextBoolean();
        int monthNumber = random.nextInt(1, 13);
        switch (monthNumber) {
            case 1 -> System.out.println("в январе 31 день");
            case 2 -> {
                if (isLeap) System.out.println("в феврале 28 дней");
                else System.out.println("в феврале 29 дней, этот год высокосный");
            }
            case 3 -> System.out.println("в марте 31 день");
            case 4 -> System.out.println("в апреле 30 дней");
            case 5 -> System.out.println("в мае 31 день");
            case 6 -> System.out.println("в июне 30 дней");
            case 7 -> System.out.println("в июле 31 день");
            case 8 -> System.out.println("в августе 31 день");
            case 9 -> System.out.println("в сентябре 30 дней");
            case 10 -> System.out.println("в октябре 31 день");
            case 11 -> System.out.println("в ноябре 30 дней");
            case 12 -> System.out.println("в декабре 31 день");
        }
        //--------------------------Задача 5-----------------------------------------//


        int couponNumber = random.nextInt(1, 5556);
        double resultSum = 700_000.0;
        resultSum = switch (couponNumber) {
            case 1111 -> (resultSum * .9);
            case 3333 -> (resultSum * .8);
            case 5555 -> (resultSum * .7);
            default -> resultSum;
        };
        System.out.println(resultSum);

    }
}
