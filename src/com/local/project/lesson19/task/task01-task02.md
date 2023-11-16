## Задание 1 (на методы Stream)
1. в чём разница между методами `peek` и `map`?
2. в чём разница между методами `peek` и `foreach`?
3. в чём разница между методами `map` и `flatMap`?
4. в чём разница между методами `map` и `mapToInt`?

## Задание 2 
Дан список машин


        List<Car> vehicles = List.of(
            new Car(Repaintable.Color.GOLD, "001"),
            new MiniCar(Repaintable.Color.ORANGE, "002"),
            new MiniCar(Repaintable.Color.BLACK, "003"),
            new Car(Repaintable.Color.RED, "004"),
            new Car(Repaintable.Color.BLACK, "005"),
            new MiniCar(Repaintable.Color.ORANGE, "006")
        );

### Задание 2.1
1. отсортировать по уровню износа от большего к меньшему `.sorted(Comparator comparator)`
2. получить список номеров транспортных средств `.toList()`

### Задание 2.2
1. получить суммарный уровень износа транспортных средств `.mapToInt(ToIntFunction function)` и `.sum()`

### Задание 2.3
1. сменить цвет каждой машины на GOLD `.peek(Consumer consumer)`
2. вывести каждый элемент в консоль `.foreach(Consumer consumer)`