package HomeTask04;

public class GuessTask {
    public static void main(String[] args) {
        int guess = 75;
        int min = 1, max = 100;
        int buf = 0;                // на подумать нужен ли тут буфер...дальше он не задействован
                                    // как предполагалось...но прога работает правильно!

        int count = 0;
        boolean isAlive = true;
        while (isAlive) {
            buf = (max + min)/2;
            count++;
            if (buf == guess) {
                System.out.println("вы угадали, попыток " + count);
                isAlive = false;
            }
            else if (guess > buf) {
                count++;
                min = buf +1;
                buf = (max + min)/2;
            }else {
                count++;
                max = buf - 1;
                buf = (max + min)/2;
            }
        }
    }
}
