package com.local.project.lesson19.task.task03;


import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;



public class Task03 {
    public static void main(String[] args) {
        // Написать реализацию методов task01 - task04
        // Перед выполнением посмотрите методы flatMap / flatMapToInt / map / mapToInt / allMatch / anyMatch / noneMatch
        // Некоторые из этих методов могут понадобиться при решении задач
        Author[] authors01 = new Author[] {
        new Author("name01", "email01", LocalDate.of(2000, 11, 12)),
        new Author("name02", "email02", LocalDate.of(2005, 11, 12)),
        new Author("name03", "email03", LocalDate.of(2010, 11, 12))};

        Author[] authors02 = new Author[] {
                new Author("name04", "email04", LocalDate.of(2003, 11, 12)),
                new Author("name05", "email05", LocalDate.of(2008, 11, 12)),
                new Author("name06", "email06", LocalDate.of(2013, 11, 12))};

        Article article01 = new Article("book", Article.Category.TRAVELLING, authors01);
        Article article02 = new Article("book", Article.Category.FOOD, authors02);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article01);
        articles.add(article02);

        task01(articles);
        task02(articles, Article.Category.TRAVELLING);
        task03(articles, Article.Category.TRAVELLING, 15, 19);
    }

    public static Double task01(ArrayList<Article> articles){
        // Вернуть средний возраст авторов статей
        if (articles == null) throw new IllegalArgumentException("articles must not be null");

        List<HashMap<String, Author>> authorsList = articles.stream().map(Article::getAuthors).toList(); // вытаскиваю из коллекции мапу

        ArrayList<String> authorEmails = new ArrayList<>(); // объявляю список email, для хранения key map

        LocalDate currentDate = LocalDate.now();
        int sumBirth = 0;
        for (HashMap<String, Author> authors : authorsList){
                for (Map.Entry<String, Author> avt : authors.entrySet()){
                    authorEmails.add(avt.getKey());// записываю в список key каждый email
                    sumBirth += calculateAge(avt.getValue().getBirth(), currentDate); // вычисляю сумму возрастов всех авторов
                }
        }
        System.out.printf("Task01\n" +
                        "sumBirth- %d, count Author - %d, average age of article authors - %.2f\n",
                sumBirth, authorEmails.size(), (double)sumBirth/authorEmails.size());
//        AtomicInteger i = new AtomicInteger(0);
//        int sumBirth = authorsList.stream().map(authors -> authors.get(authorEmails.get(i.getAndIncrement()))).
//                mapToInt(author -> calculateAge(author.getBirth(), LocalDate.now())).sum(); // вычисляю сумму возрастов всех авторов
        return (double)sumBirth/authorEmails.size(); // возвращаю средний возраст авторов
    }

    public static List<String> task02(ArrayList<Article> articles, Article.Category category) {
        // Вернуть список email авторов статей категории == category
        if (articles == null) throw new IllegalArgumentException("articles must not be null");

        List<HashMap<String, Author>> authorsList = articles.stream().filter(x -> x.getCategory() == (category)).map(Article::getAuthors).toList(); // вытаскиваю из коллекции мапу

        List<String> authorEmails = new ArrayList<>(); // объявляю список email, для хранения key map

        for (HashMap<String, Author> authors : authorsList) {
            for (Map.Entry<String, Author> avt : authors.entrySet()) {
                authorEmails.add(avt.getKey());// записываю в список key каждый email
            }
        }
        System.out.printf("Task02\n" +
                "list of email authors of category articles == category - %s", authorEmails);
                return authorEmails;
            }
    public static List<String /*Article*/> task03(ArrayList<Article> articles, Article.Category category, int min, int max){
        // Поменял тип возвращаемого значения, т.к. в задание вернуть список статей, а статьи типизированы String
        // Вернуть список статей категории == category,
        // возраст авторов которых попадает в диапазон от min до max

//        if (articles == null) throw new IllegalArgumentException("articles must not be null");
//
//        List<HashMap<String, Author>> authorsList = articles.stream().filter(x -> x.getCategory() == (category)).
//                map(Article::getAuthors).toList(); // вытаскиваю из коллекции мапу
//
//        List<String> titleList = new ArrayList<>(); // объявляю список email, для хранения key map
//
//        LocalDate currentDate = LocalDate.now();
//        for (HashMap<String, Author> authors : authorsList) {
//            for (Map.Entry<String, Author> avt : authors.entrySet()) {
//                if (calculateAge(avt.getValue().getBirth(), currentDate) >= min &&
//                        calculateAge(avt.getValue().getBirth(), currentDate) <= max)
//                titleList.add(avt.get);// записываю в список key каждый email
//            }
//        }
//        System.out.printf("Task02\n" +
//                "list of articles in category == category," +
//                " the age of the authors of which falls in the range from min to max - %s", titleList);
        return null;
    }
    public static List<Article> task04(ArrayList<Article> articles, Article.Category category){
        // Вернуть список статей категории == category, опубликованных сегодня
        return null;
    }
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}