package com.local.project.lesson1516.homeTask16;


import java.util.*;

public class FruitsStorage {
    // максимальное количество фруктов
    private int numberOfSlots;

    // коллекция fruits, для хранения экземпляров FruitType
    private final ArrayList<Fruit> fruits = new ArrayList<>();

    public FruitsStorage(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    // Реализация методов
    public boolean addToStorage(Fruit fruit) {
        /*
         фрукты добавляются в хранилище по следующим правилам:
         * fruit не может быть null
         * в хранилище нельзя добавить больше numberOfSlots фруктов
         * fruit не может быть ссылкой на существующий элемент коллекции
         * если в коллекции fruits уже есть фрукт с типом и ценой, как у fruit,
           увеличивать значение свойства count фрукта коллекции на значение свойства count
           добавляемого фрукта. В противном случае добавлять fruit в коллекцию fruits.
           numberOfSlots уменьшается на значение count добавляемого фрукта.
        */
        Objects.requireNonNull(fruit, "fruit не может быть null");
        if (fruit.getCount() > numberOfSlots) throw new IndexOutOfBoundsException("в хранилище нельзя добавить больше "
                + numberOfSlots + " фруктов");
        if (fruits.size() == 0) {
            fruits.add(fruit);
            numberOfSlots -= fruit.getCount();
            return true;
        }
        if (fruits.contains(fruit)) throw new IllegalArgumentException("в хранилище уже есть фрукт " + fruit);
        Comparator<Fruit> byPrice = new Fruit.PriceComparator(); // пробую сравнение через Comparator
        for (Fruit line : fruits) {
            if (line.getType() == fruit.getType() && byPrice.compare(fruit, line) == 0) {
                line.setCount(line.getCount() + fruit.getCount());
                numberOfSlots -= fruit.getCount();
                return true;
            }
        }
            fruits.add(fruit);                   //Совмещать с предыдущим циклом нельзя, т.к. будут добавляться фрукты с
            numberOfSlots -= fruit.getCount();   // одинаковой ценой в разные ящики
            return true;
        }

    // вернуть количество фруктов определённого типа
    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        int count = 0;
        for (Fruit line : fruits) {
            if (line.getType() == fruitType) count++;
        }
        return count;
    }

    // вернуть количество свободных мест в хранилище
    public int getNumberOfEmptySlots() {
        return numberOfSlots;
    }

    public void increasePrice(int value) {
        // value может быть в диапазоне [10; 30)
        // увеличить цену всех фруктов на value процентов
        if (value < 10 || value >= 30) throw new IllegalArgumentException("value может быть в диапазоне [10; 30)");
        double percent = value / 100.00 + 1;
        for (Fruit line : fruits) {
            line.setPrice(line.getPrice() * percent);
        }
    }

    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        // maxPrice должна быть положительной, fruitType не null
        // возвращает список, в который войдут фрукты из коллекции fruits
        // с типом fruitType и ценой не выше maxPrice
        if (maxPrice <= 0.0 && fruitType == null)
            throw new IllegalArgumentException("maxPrice должна быть положительной, fruitType не null");
        List<Fruit> list = new ArrayList<>();
        for (Fruit line : fruits) {
            if (line.getType() == fruitType && line.getPrice() <= maxPrice) list.add(line);
        }
        return list;
    }

    public Set<Fruit.FruitType> getFruitTypes() {
        // возвращает ссылку на множество с типами фруктов в хранилище
        Set<Fruit.FruitType> setFruitType = new HashSet<>();
        for (Fruit line : fruits) {
            setFruitType.add(line.getType());
        }
        return setFruitType;
    }

    public double getMinPriceByType(Fruit.FruitType fruitType) {
        // вернуть минимальную цену фрукта с типом fruitType
        int count = 0;
        double minPrice = Double.MAX_VALUE;
        for (Fruit line : fruits) {
            if (line.getType() == fruitType) {
                minPrice = Math.min(minPrice, line.getPrice());
                count++;
            }
        }
        if (count == 0) throw new IllegalArgumentException("Список не содержит тип фрукта " + fruitType);
        return minPrice;
    }

    @Override
    public String toString() {
        return fruits.toString();
    }

    public static void main(String[] args) {
        FruitsStorage fs = new FruitsStorage(100);
        fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 700.00, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.BANANA, 700.00, 4));
        fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 700.00, 3));
        fs.addToStorage(new Fruit(Fruit.FruitType.BANANA, 700.00, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 700.00, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.BANANA, 700.00, 33));
        fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 107.00, 3));
        fs.addToStorage(new Fruit(Fruit.FruitType.APRICOT, 700.00, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.PEAR, 700.00, 6));
        fs.addToStorage(new Fruit(Fruit.FruitType.BANANA, 100.00, 7));
        fs.addToStorage(new Fruit(Fruit.FruitType.APRICOT, 700.00, 3));
        fs.addToStorage(new Fruit(Fruit.FruitType.BANANA, 600.00, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.APRICOT, 100.40, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.PEAR, 189.00, 5));
        fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 15.08, 5));
//        fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 104.00, 1));


        System.out.println();
        System.out.println(fs);  // ок
        System.out.println();

        Set<Fruit.FruitType> fruitTypes = fs.getFruitTypes();
        System.out.println(fruitTypes); // ок
        System.out.println();

        System.out.println(fs.getNumberOfFruitsByType(Fruit.FruitType.APPLE)); // ок
        System.out.println();

        System.out.println(fs.getNumberOfEmptySlots()); // ок
        System.out.println();

        fs.increasePrice(29); // ок
        System.out.println(fs);
        System.out.println();

        System.out.println(fs.getMinPriceByType(Fruit.FruitType.APPLE));
        System.out.println();

        for (Fruit line : fs.fruits) {
            if (line.getType() == Fruit.FruitType.APPLE)
                System.out.println(line.getPrice());
        }
        System.out.println();
        System.out.println(fs.getFruitsByTypeAndPrice(Fruit.FruitType.APPLE, 200)); // ок
        System.out.println();

        System.out.println(fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 104.00, 1))); // ок
    }
}

