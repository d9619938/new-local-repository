package com.local.project.lesson12.exception;

public class Exceptions {
    public static void main(String[] args) {
        // Исключение времени выполнения (Наследники RuntimeException)
        // необрабатываемые (unchecked) - можем реагировать, можем не обрабатывать
        int [] ints = new int[4];
        int index = 9;
        ints[index] = 5; // java.lang.ArrayIndexOutBoundsException

        Object object = "Hello"; // у объекта тип данных String
        Integer integer = (Integer) object; //ClassCastException, привели к несовместимому типу

        System.out.println(4/0); // ArithmeticException
        String string = null;
        System.out.println(string.length()); // NullPointerException

        // все исключения (времени выполнения и компиляции обрабатываются в try-catch)

        try {
            // потенциально опасный код
            System.out.println(string.length()); // если тут произошло исключение, то управление переходит в блок catch

        } catch (NullPointerException e) {
            System.out.println(" "); // инструкции для блока обработки исключения
            e.getCause(); // - причина исключения
            e.getMessage(); // - сообщение об ошибке, без описания где она произошла
        }

        try {
            //  потенциально опасный код
            System.out.println(string.length());
            Integer integer01 = (Integer) object;
        } catch (NullPointerException e) {  // несколько блоков, если есть необходимость реагировать на разные исключения
            System.out.println(e.getMessage());
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        try {
            // потенциально опасный код
        } catch (NullPointerException | ClassCastException e) {  // сравниваются побитовым ИЛИ
            System.out.println(e.getMessage());
        }
        // в блоке try-catch не приветствуется проверка на тип исключения!!!

        try {
            //  потенциально опасный код
            System.out.println(string.length());
        } catch (RuntimeException e) { // все исключения времени выполнения
            System.out.println(e.getMessage());
        }

        // если необходимо обработать несколько исключений, то необходимо в блоках указывать их от дочернего к родительскому

        try {
            User user = new User(3);
            User copy = user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
