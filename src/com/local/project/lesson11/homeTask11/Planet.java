package com.local.project.lesson11.homeTask11;

// Написать перечисление с планетами солнечной системы.
// Для каждой планеты необходимо задать название, массу и радиус.

public enum Planet {
    MERCURY("Mercury", 3.285E23f, 2429.7f),
    VENUS ("Venus", 4.867E24f, 6051.8f),
    EARTH("Earth", 5.972E24f, 6371f),
    MARS("Mars", 6.39E23f, 3389.5f),
    JUPITER("Jupiter", 1.898E27f, 69911f),
    SATURN("Saturn", 5.683E26f,58232f),
    URANUS("Uranus", 8.681E25f,25362f),
    NEPTUNE ("Neptune", 1.024E26f, 24622f);
    private String name;
    private float mass;
    private float rad;

    Planet(String name, float massKg, float radKm) {
        setName(name);
        setMass(massKg);
        setRad(radKm);
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public float getMass() {
        return mass;
    }

    private void setMass(float mass) {
        this.mass = mass;
    }

    public double getRad() {
        return rad;
    }

    private void setRad(float rad) {
        this.rad = rad;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", rad=" + rad +
                '}';
    }
}
