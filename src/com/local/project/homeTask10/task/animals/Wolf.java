package com.local.project.homeTask10.task.animals;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal {
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    protected String getColor() {
        return this.color;
    }
    protected String[] getLikeToEat () {
        return likeToEat;
    }

//    Ёкземпл€ры Wolf считаютс€ равными по методу equals, если равны значени€ всех их свойств.
//    »сход€ из задани€ провер€ю на равенство все свойства класса Wolf, в том числе наследованные от родительских классов.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wolf wolf)) return false;
        if (getName() == null && wolf.getName() != null) return false; // избавл€юсь от NPE
        if (getName() == null && wolf.getName() == null) // если оба String null, сравниваю уже без них
            return Arrays.equals(likeToEat, wolf.likeToEat) && Objects.equals(color, wolf.color)
                    && getStrength() == wolf.getStrength() && getAge() == wolf.getAge();
        else return Arrays.equals(likeToEat, wolf.likeToEat) && Objects.equals(color, wolf.color) //
                && getStrength() == wolf.getStrength() && getAge() == wolf.getAge() && getName().equals(wolf.getName());
    }

    public static void main(String[] args) {

        Animal[] animals = new Animal[]{giveBirthToAWolf(), giveBirthToAWolf()}; // массив типа Animal с объектами Wolf
        Wolf wolfOne = (Wolf) animals[0]; // привожу к типу Wolf, чтобы работать со свойствами Wolf
        Wolf wolfTwo = (Wolf) animals[1];
        check(wolfOne, wolfTwo);
        addMeanings(wolfOne, wolfTwo);
        check(wolfOne, wolfTwo);
        wolfOne.setName(null);
        check(wolfOne, wolfTwo); // проверка NPE
        wolfOne.setName("»ван");
        check(wolfOne, wolfTwo);
    }
}
