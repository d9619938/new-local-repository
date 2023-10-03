package HomeTask02;


public class ArithmeticTask {
    public static void main (String[] args) {
/*
        1. объявите переменные для хранения информации об общем количестве писем и о количестве отправленных писем. Присвойте
        значения этим переменным. Выведите в консоль, сколько писем осталось отправить.
*/
        int totalNumberOfLetters;
        int numberOfLettersSent;
        totalNumberOfLetters = 100;
        numberOfLettersSent = 37;
        System.out.printf("1) Сколько писем осталось отправить - %s\n", (totalNumberOfLetters - numberOfLettersSent));

/*
        2. Объявить и инициализировать переменные для хранения времени (в часах) и расстояния (в километрах). Найти и вывести в
        консоль скорость, выраженную в метрах в секунду.
*/
        int timeInHours = 3;
        int distanceInKilometers = 70;

        double speedInMetersPerSecond = ((double) distanceInKilometers / timeInHours) / 3.6;
        System.out.printf("2) Скорость равна - %.2f м/c\n",speedInMetersPerSecond);

/*
        3. Найти сумму цифр целого положительного двузначного числа. Результат вывести в консоль.
*/
        int number = 72;
        int result = (number / 10) + (number % 10);
        System.out.println("3) Сумма цифр целого положительного числа = " + result);

/*
        4. Поменять значения 2х переменных местами, используя арифметические операторы. Результат вывести в консоль.
*/
        int one = 54;
        int two = 98;
        System.out.println("4) До перестановки: " + one + " " + two);

        two = one + two; // 152
        one = two - one; // 152 - 54 = 98
        two = two - one; // 152 - 98 = 54

        System.out.println("   После перестановки: " + one + " " + two);
    }
}
