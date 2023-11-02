package com.local.project.exam01;

import java.time.LocalDate;

public class Helper {
    public static boolean isAlfa (String str) {
        return str.chars().allMatch(Character ::isLetter);
    }

    private static Visitor generateVisitor() {
        String firstName = "Николай, Руслан, Алексей, Юрий, Ярослав, Семен, Евгений, Олег, Артур, Петр, Степан," +
                " Илья, Вячеслав, Сергей, Василий, Степан, Федор, Стас, Вячеслав, Георгий, Антон, Борис, Захар," +
                " Арсений, Виктор, Родион, Святослав, Игорь, Гордей";
        String[] arrFirstName = firstName.split(", ");

        String lastName = "Иванов\tСмирнов\tКузнецов\tПопов\tВасильев\tПетров\tСоколов\tМихайлов\tНовиков\t" +
                "Фёдоров\tМорозов\tВолков\tАлексеев\tЛебедев\tСемёнов\tЕгоров\tПавлов\tКозлов\tСтепанов\t" +
                "Николаев\tОрлов\tАндреев\tМакаров\tНикитин\tЗахаров";
        String[] arrLastName = lastName.split("\t");


        int randomName = (int)(Math.random()*(arrFirstName.length));
        int randomLastName = (int)(Math.random()*(arrLastName.length));
        int minY = 1963;
        int maxY = 2005;
        maxY -= minY;
        int randomYear = (int)(Math.random() * ++maxY) + minY;
        int minM = 1;
        int maxM = 12;
        maxM -= minM;
        int randomMonth = (int)(Math.random() * ++maxM) + minM;
        int minD = 1;
        int maxD = 28;
        maxD -= minD;
        int randomDay = (int)(Math.random() * ++maxD) + minD;
        return new Visitor(arrFirstName[randomName], arrLastName[randomLastName], LocalDate.of(randomYear, randomMonth, randomDay));
    }
    protected static Card generateCard() {

        int minY = 2024;
        int maxY = 2050;
        maxY -= minY;
        int randomYear = (int)(Math.random() * ++maxY) + minY;
        int minM = 1;
        int maxM = 12;
        maxM -= minM;
        int randomMonth = (int)(Math.random() * ++maxM) + minM;
        int minD = 1;
        int maxD = 28;
        maxD -= minD;
        int randomDay = (int)(Math.random() * ++maxD) + minD;
        int randomType = (int)(Math.random() * 3);
        return new Card(CardType.values()[randomType], LocalDate.of(randomYear, randomMonth, randomDay), generateVisitor());
    }
}
