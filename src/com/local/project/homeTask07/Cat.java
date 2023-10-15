package com.local.project.homeTask07;

import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Cat {
    private String name = "Мурзик";
    private int weight;
    private int attackCount;

    public Cat (int weight) {
        setWeight(weight);
    }

    public void setName(String name) {
        if (name.strip().length() < 3) {
            throw new IllegalArgumentException("Ошибка, имя кота не должно быть меньше 3х символов без учета пробелов");
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setWeight(int weight) {
        if (weight < 1 || weight >= 9) {
            throw new IllegalArgumentException("Ошибка, вес кота должен быть в диапазоне [1, 9)");
        }
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public int getAttackCount() {
        return attackCount;
    }

    public boolean attack (Cat cat) {
        if (cat == null){
            throw new IllegalArgumentException("Ошибка, кот не может быть null");
        } if (cat.getWeight() == this.weight) {
            throw new IllegalArgumentException("Ничья, вес котов равный");
        }
        else if (cat.getWeight() > this.weight) {
            System.out.println("Победил нападавший кот по имени " + cat.getName());
            cat.attackCount++;
            return true;
        }
        System.out.println("Победил защищавшийся кот по имени " + name);
        attackCount++;
        return false;
    }
    public static void main (String[] args) {

        Cat catOne = new Cat(1);
        catOne.setName("Пират");
        Cat catTwo = new Cat(6);

        catTwo.attack(catOne);
        catTwo.setName("МУРЗИК ЛЕГЕНДА");
        catOne.attack(catTwo);

        catOne.setWeight(8);
        catOne.attack(catTwo);

        System.out.printf("Количество побед кота по имени %s - %d\n",catOne.getName(), catOne.getAttackCount());
        System.out.printf("Количество побед кота по имени %s - %d\n",catTwo.getName(), catTwo.getAttackCount());

    }
}
