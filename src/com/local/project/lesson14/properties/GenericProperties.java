package com.local.project.lesson14.properties;

import com.local.project.lesson14.properties.service.Service;
import com.local.project.lesson14.properties.vehicle.*;

public class GenericProperties {
    public static void main(String[] args) {
        User<String> stringUser = new User<>("34rr");
        stringUser.setId(stringUser.getId().toLowerCase());

        User<Integer> integerUser = new User<>(1);
        integerUser.setId(integerUser.getId() + 1);

        // необработанный / сырой / raw тип
        User rawUser = new User("12");
        rawUser.setId(12);
        rawUser.setId(stringUser);
        System.out.println(rawUser.getId().toString());

        // Типизированные свойства с ограничениями
        Train train01 = new Train("train01", 7, false);
        Car car01 = new Car(Repaintable.Color.ORANGE, "car01");
        Bus bus01 = new Bus("bus01");
        MiniCar mini01 = new MiniCar(Repaintable.Color.BLUE, "mini01");

        // 1. public class Service<T extends Vehicle & Repaintable> {}
        // 2. поэтому в <> можно указать тип, который является типом Vehicle и типом Repaintable,
        // плюс любых его подтипов. В данном случае только Car и MiniCar отвечают данным требованиям:
        // Car extends Vehicle implements Repaintable {}
        // MiniCar extends Car {}
        // 3. в качестве generic свойства можно передать тип указанный в <> и все его подтипы

        Service<Car> service01 = new Service<>(car01); // car01 или mini01
        Service<Car> service02 = new Service<>(mini01); // car01 или mini01
        Service<MiniCar> service03 = new Service<>(mini01); // только mini01

    }
}
