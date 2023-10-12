package homeTask04;

public class SubsequenceTask {
    public static void main (String[] str) {
        int count = 0;
        for (int i = 0; count < 10; i ++) { // можно начать с 2, без проверки на ноль
            if (i != 0 && i % 2 == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
    }
}


