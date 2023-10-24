package com.local.project.lesson11;

// enum могут реализовывать интерфейсы
// enum не могут расширять другие классы,
// так как в enum уже реализовано наследование
public enum County {        // Country - тип enum объектов
    FRANCE("Франция", 214876) {
        public void franceVoid() {} //этот метод не будет виден снаружи объекта, его можно использовать как вспомогательный

        @Override
        public void sout (){ //
        System.out.println("реализован абстрактный метод");
        }
    }, USA("USA", 467834){
        @Override
        public void sout (){}
    },
    ITALY("Америка", 1678434522462L)  // объекты типа Country
            {
                @Override
                public void sout(){}
            };
    private String name; // можно использовать и статик для всех объектов
    private long population;

    County(){}
    County(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
    abstract public void sout();
}
