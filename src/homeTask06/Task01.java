package homeTask06;

public class Task01 {
    public static void main(String[] args) {
/*Задача #1
Дана строка, содержащая только буквы и цифры. Вывести информацию о том, является ли данная трока палиндромом.*/

        String str01 = null;
        String str02 = "";
        String str03 = "перевертень";
        String str04 = "33 Saippuakivikauppias 33";
        String str05 = "101sos101";
        checkForPalindrom(str01);
        checkForPalindrom(str02);
        checkForPalindrom(str03);
        checkForPalindrom(str04);
        checkForPalindrom(str05);
    }

    public static void checkForPalindrom(String string) {
        if (string != null) {
            StringBuilder sb = new StringBuilder(string);
            String check = sb.reverse().toString();
            System.out.printf("Является ли строка \"%s\" палиндромом - %B\n",
                    string, (string.equalsIgnoreCase(check) ? true : false));
        } else
            System.out.println("Ошибка, строка содержит \"null\"");
    }
}
