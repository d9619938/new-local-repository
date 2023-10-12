package homeTask04;
import java.util.Scanner;
public class GuessTask01 {
    public static void main(String[] args) {

        int answer = (int) (Math.random() * 9 + 1);
        Scanner scanner = new Scanner(System.in);
        boolean isRight = false;
        System.out.println("Ведите целое число");
        do {
            System.out.println();
            if (scanner.hasNextInt()) {
                int guessNumber = scanner.nextInt();
                if (guessNumber == answer) {
                    System.out.println("Вы угадали");
                    isRight = true;
                } else if (guessNumber == 0) {
                    System.out.println("выход из программы");
                    isRight = true;
                } else if (guessNumber < answer) {
                    System.out.println("загаданное число больше");
                } else {
                    System.out.println("загаданное число мельше");
                }
            } else {
                scanner.next();
            }
        } while (!isRight);
    }
}
