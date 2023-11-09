В решениях не использовать лямбда выражения, stream API и collectors API

## Задача №1.

Реализовать статический метод, который принимает `Collection<String> strings` и возвращает количество одинаковых слов в
коллекции `strings` в виде `Map<String, Long>`. Где ключи - слова, а значения - количество повторений.

## Задача №2.

Реализовать статический метод, принимающий на вход `String word` и `String text` и возвращающий частоту встречаемости
слова `word` в тексте `text` в виде `Map<String, Long>`. Где ключ - слово, а значение - частота встречаемости

## Задача №3.

Реализовать статический метод, принимающий на вход `String text` и возвращающий `Map<Integer, List<String>>`где ключи -
количество букв в словах, значения - списки соответствующих слов.

## Задача №4.

Реализовать статический void метод, принимающий на вход `String text` и выводящий в консоль топ 10 самых часто
встречаемых в тексте слов (можно добавить условие: артикли и предлоги не считаем за слова).

## Текст для проверок задач с 2 по 4


        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";