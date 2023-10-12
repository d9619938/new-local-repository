package homeTask06;

import java.sql.SQLOutput;

public class Task02 {
    public static void main(String[] args) {
        /*Задача #2
Даны две строки, строки, содержащие только буквы английского алфавита.
Вывести информацию о том, являются ли одна строка анаграммой другой строки.*/

        // создаем разные варианты строк, для проверки большего кол-ва вариантов
        String str01 = "DimA";
        String str02 = "aMid";
        String str03 = "foma";
        String str04 = "";
        String str05 = "";
        String str06 = null;
        String str07 = null;
        System.out.print("Результат 01 - ");
        checkForAnagramm(str01, str02);
        System.out.print("Результат 02 - ");
        checkForAnagramm(str01, str03);
        System.out.print("Результат 03 - ");
        checkForAnagramm(str04, str05);
        System.out.print("Результат 04 - ");
        checkForAnagramm(str01, str06);
        System.out.print("Результат 05 - ");
        checkForAnagramm(str06, str07);

    }

    public static void checkForAnagramm(String one, String two) { // можно и через сортировку решить, но это просто.
        if (one != null && two != null && one.length() == two.length()) {
            int countCheck = 0;
            for (int i = 0; i < one.length(); i++) {
                for (int j = 0; j < two.length(); j++) {
                    if (one.toLowerCase().charAt(i) == two.toLowerCase().charAt(j)) { // необходимо привести к единому
                        // регистру, для исключения некорректной работы из-за разных символов типа "а" и "А".
                        countCheck++;
                    }
                }
            }
            if (countCheck == one.length()) {
                System.out.printf("Строка \"%s\" является анограммой строки \"%s\"\n", one, two);
            } else {
                System.out.printf("Строка \"%s\" НЕ является анограммой строки \"%s\"\n", one, two);
            }
        } else {
            System.out.println("Ошибка, строки содержат \"null \" или имеют разное кол-во символов");
        }
    }
}
