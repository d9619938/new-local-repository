package com.local.project.lesson1516.homeTask16;


import java.util.*;

public class FruitsStorage {
    // ������������ ���������� �������
    private int numberOfSlots;

    // ��������� fruits, ��� �������� ����������� FruitType
    private final ArrayList<Fruit> fruits = new ArrayList<>();

    public FruitsStorage(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    // ���������� �������
    public boolean addToStorage(Fruit fruit) {
        /*
         ������ ����������� � ��������� �� ��������� ��������:
         * fruit �� ����� ���� null
         * � ��������� ������ �������� ������ numberOfSlots �������
         * fruit �� ����� ���� ������� �� ������������ ������� ���������
         * ���� � ��������� fruits ��� ���� ����� � ����� � �����, ��� � fruit,
           ����������� �������� �������� count ������ ��������� �� �������� �������� count
           ������������ ������. � ��������� ������ ��������� fruit � ��������� fruits.
           numberOfSlots ����������� �� �������� count ������������ ������.
        */
        Objects.requireNonNull(fruit, "fruit �� ����� ���� null");
        if (fruit.getCount() > numberOfSlots) throw new IndexOutOfBoundsException("� ��������� ������ �������� ������ "
                + numberOfSlots + " �������");
        if (fruits.size() == 0) {
            fruits.add(fruit);
            numberOfSlots -= fruit.getCount();
            return true;
        }
        if (fruits.contains(fruit)) throw new IllegalArgumentException("� ��������� ��� ���� ����� " + fruit);
        Comparator<Fruit> byPrice = new Fruit.PriceComparator(); // ������ ��������� ����� Comparator
        for (Fruit line : fruits) {
            if (line.getType() == fruit.getType() && byPrice.compare(fruit, line) == 0) {
                line.setCount(line.getCount() + fruit.getCount());
                numberOfSlots -= fruit.getCount();
                return true;
            }
        }
            fruits.add(fruit);                   //��������� � ���������� ������ ������, �.�. ����� ����������� ������ �
            numberOfSlots -= fruit.getCount();   // ���������� ����� � ������ �����
            return true;
        }

    // ������� ���������� ������� ������������ ����
    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        int count = 0;
        for (Fruit line : fruits) {
            if (line.getType() == fruitType) count++;
        }
        return count;
    }

    // ������� ���������� ��������� ���� � ���������
    public int getNumberOfEmptySlots() {
        return numberOfSlots;
    }

    public void increasePrice(int value) {
        // value ����� ���� � ��������� [10; 30)
        // ��������� ���� ���� ������� �� value ���������
        if (value < 10 || value >= 30) throw new IllegalArgumentException("value ����� ���� � ��������� [10; 30)");
        double percent = value / 100.00 + 1;
        for (Fruit line : fruits) {
            line.setPrice(line.getPrice() * percent);
        }
    }

    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        // maxPrice ������ ���� �������������, fruitType �� null
        // ���������� ������, � ������� ������ ������ �� ��������� fruits
        // � ����� fruitType � ����� �� ���� maxPrice
        if (maxPrice <= 0.0 && fruitType == null)
            throw new IllegalArgumentException("maxPrice ������ ���� �������������, fruitType �� null");
        List<Fruit> list = new ArrayList<>();
        for (Fruit line : fruits) {
            if (line.getType() == fruitType && line.getPrice() <= maxPrice) list.add(line);
        }
        return list;
    }

    public Set<Fruit.FruitType> getFruitTypes() {
        // ���������� ������ �� ��������� � ������ ������� � ���������
        Set<Fruit.FruitType> setFruitType = new HashSet<>();
        for (Fruit line : fruits) {
            setFruitType.add(line.getType());
        }
        return setFruitType;
    }

    public double getMinPriceByType(Fruit.FruitType fruitType) {
        // ������� ����������� ���� ������ � ����� fruitType
        int count = 0;
        double minPrice = Double.MAX_VALUE;
        for (Fruit line : fruits) {
            if (line.getType() == fruitType) {
                minPrice = Math.min(minPrice, line.getPrice());
                count++;
            }
        }
        if (count == 0) throw new IllegalArgumentException("������ �� �������� ��� ������ " + fruitType);
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
        System.out.println(fs);  // ��
        System.out.println();

        Set<Fruit.FruitType> fruitTypes = fs.getFruitTypes();
        System.out.println(fruitTypes); // ��
        System.out.println();

        System.out.println(fs.getNumberOfFruitsByType(Fruit.FruitType.APPLE)); // ��
        System.out.println();

        System.out.println(fs.getNumberOfEmptySlots()); // ��
        System.out.println();

        fs.increasePrice(29); // ��
        System.out.println(fs);
        System.out.println();

        System.out.println(fs.getMinPriceByType(Fruit.FruitType.APPLE));
        System.out.println();

        for (Fruit line : fs.fruits) {
            if (line.getType() == Fruit.FruitType.APPLE)
                System.out.println(line.getPrice());
        }
        System.out.println();
        System.out.println(fs.getFruitsByTypeAndPrice(Fruit.FruitType.APPLE, 200)); // ��
        System.out.println();

        System.out.println(fs.addToStorage(new Fruit(Fruit.FruitType.APPLE, 104.00, 1))); // ��
    }
}

