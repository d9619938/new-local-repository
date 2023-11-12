package com.local.project.lesson17.task;

import java.util.*;

public class HomeTask01 {
    private static final String TEXT = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
            "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
            "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
            "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
            "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
            " sometimes on purpose injected humour and the like";

    public static void main(String[] args) {
        HomeTask01 task01 = new HomeTask01();
        task01.mission01();
        System.out.println();

        task01.mission02();
        System.out.println();

        task01.mission03();
        System.out.println();

        task01.mission04();
        System.out.println();

    }

    private static Map<String, Long> addMapString(Collection<String> strings) {
        //        Реализовать статический метод, который принимает Collection<String> strings и возвращает количество
        //        одинаковых слов в коллекции strings в виде Map<String, Long>.
        //        Где ключи - слова, а значения - количество повторений.
        if (strings == null) throw new IllegalArgumentException("strings not null");
        Map<String, Long> stringLongMap = new HashMap<>();
        for (String str : strings) {  // перебираем коллекцию строк
            if (str != null) str = str.toLowerCase();
            if (stringLongMap.containsKey(str)) {
                stringLongMap.put(str, stringLongMap.get(str) + 1); // устанавливаем значение для второго вхождения
            } else {
                stringLongMap.put(str, 1L);  // устанавливаем дефолтное значение для первого вхождения
            }
        }
        return stringLongMap;
    }

    private static Long numberOfOccurrences(String word, String text) {
        //Реализовать статический метод, принимающий на вход String word и String text и возвращающий
        // частоту встречаемости слова word в тексте text в виде Map<String, Long>.
        // Где ключ - слово, а значение - частота встречаемости
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>();
        for (String w : results) {
            strings.add(w.toLowerCase());
        }
        Map<String, Long> map = addMapString(strings);
        System.out.println(map);
        return map.get(word.toLowerCase().trim());
    }

    private static Map<Integer, List<String>> getIntegerListMap(String text) {
//        Реализовать статический метод, принимающий на вход String text и возвращающий
//        Map<Integer, List<String>> где ключи - количество букв в словах,
//        значения - списки соответствующих слов.
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>(); // коллекция тут явно лишняя, надо пробовать без нее...
        int maxLengthWord = 0;
        for (String w : results) {
            strings.add(w);
            int wLength = w.length();
            maxLengthWord = Math.max(maxLengthWord, wLength);
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 1; i <= maxLengthWord; i++) {
            List<String> stringList = new ArrayList<>();
            for (String str : strings) {
                str = str.toLowerCase();
                if (str.length() == i && !stringList.contains(str)) {
                    stringList.addFirst(str);
                }
            }
            map.put(i, stringList);
        }
        return map;
    }

    private static void getTop10(String text) {
//        Реализовать статический void метод, принимающий на вход String text и выводящий в консоль топ 10
//        самых часто встречаемых в тексте слов (можно добавить условие: артикли и предлоги не считаем за слова).
        if (text == null) throw new IllegalArgumentException("text not null");
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        String[] results = result.split(" ");
        Collection<String> strings = new ArrayList<>();
        Collections.addAll(strings, results);
        Map<String, Long> map = addMapString(strings);

        Set<Map.Entry<String, Long>> mapSet = map.entrySet();

        long numberOfRepetitions = 0L; //определяем самое популярное слово в тексте
        for (Map.Entry<String, Long> m : mapSet) {
            numberOfRepetitions = numberOfRepetitions > m.getValue() ? numberOfRepetitions : m.getValue();
        }

        final String prepositionsAndArticle = "aboard\tabout\tabove\tabsent\tacross\tafore\tafter\tagainst\talong\tamid\tamidst\tamong\t" +
                "amongst\taround\tas\taside\taslant\tastride\tat\tathwart\tatop\tbar\tbefore\tbehind\tbelow\tbeneath\t" +
                "beside\tbesides\tbetween\tbetwixt\tbeyond\tbut\tby\tcirca\tdespite\tdown\texcept\tfor\tfrom\tgiven\t" +
                "in\tinside\tinto\tlike\tmid\tminus\tnear\tneath\tnext\tnotwithstanding\tof\toff\ton\topposite\tout\t" +
                "outside\tover\tpace\tper\tplus\tpost\tpro\tqua\tround\tsave\tsince\tthan\tthrough\ttill\ttimes\tto\t" +
                "toward\ttowards\tunder\tunderneath\tunlike\tuntil\tup\tversus\tvia\tvice\twith\twithout\t\tbarring\t" +
                "concerning\tconsidering\tdepending\tduring\tgranted\texcepting\texcluding\tfailing\tfollowing\t" +
                "including\tpast\tpending\tregarding\t\talongside\twithin\toutside\tupon\tonto\tthroughout\twherewith\t" +
                "a\tan\tthe\n";
//        int numberOfTop10 = 1;
//        while (numberOfRepetitions > 0L) { // пробегаем по списку пар
//            for (Map.Entry<String, Long> m : mapSet) {
//                if (numberOfTop10 <= 10 && m.getValue() == numberOfRepetitions && !prepositionsAndArticle.contains(m.getKey())) {
//                    System.out.printf("№%d в рейтинге TOP10: %d раз встречается слово \"%s\"%n",
//                            numberOfTop10, numberOfRepetitions, m.getKey());
//                    numberOfTop10++;
//                }
//            }
//            numberOfRepetitions--;
//        }   //
        TreeMap<Long, ArrayList<String>> top10 = new TreeMap<>();

        for (Map.Entry<String, Long> m : mapSet) {
            ArrayList<String> topString = new ArrayList<>();
            if (!prepositionsAndArticle.contains(m.getKey()))
                if (top10.containsKey(m.getValue())) {
                    ArrayList<String> duplicate = top10.get(m.getValue());
                    duplicate.add(m.getKey());
                    top10.put(m.getValue(), duplicate);
                } else {
                    topString.add(m.getKey());
                    top10.put(m.getValue(), topString);
                }
        }

        Set<Map.Entry<Long, ArrayList<String>>> top10Entry = top10.entrySet();
        Long max = 0L;
            for (Map.Entry<Long, ArrayList<String>> entry : top10Entry) {
                max = max > entry.getKey() ? max : entry.getKey();
            }
        int i = 0;
        while (max > 0) {
            for (Map.Entry<Long, ArrayList<String>> entry : top10Entry) {
                if (entry.getKey() == max) {
                    System.out.printf("№%d в рейтинге TOP10: %d раз встречается слово(а) %s\n", ++i, entry.getKey(), entry.getValue());
                }
            }
            max--;
        }

        }

    private void mission01() {
        Collection<String> strings = new ArrayList<>();
        strings.add("СПБ");
        strings.add("Москва");
        strings.add("СПБ");
        strings.add("Воронеж");
        strings.add(null);
        strings.add("СПБ");
        strings.add("Воронеж");
        strings.add("Воронеж");
        strings.add(null);
        strings.add("СПБ");

        System.out.println();
        System.out.println("Задание 1: Результата работы метода addMapString()");
        System.out.println(addMapString(strings));
    }

    private void mission02() {
        String word = "   Content ";
        System.out.println("Задание 2: Результат работы метода numberOfOccurrences (String word, String text)");
        System.out.println(String.format("Слово \"%s\" встречается в тексте %d раз(а)", word, numberOfOccurrences(word, TEXT)));
    }

    private void mission03() {
        System.out.println("Задание 3: Результат работы метода getIntegerListMap");
        System.out.println(getIntegerListMap(TEXT));
    }

    private void mission04() {

        System.out.println("Задание 4: Результат работы метода getTop10");
        getTop10(TEXT);
    }

}

