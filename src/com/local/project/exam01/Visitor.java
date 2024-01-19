package com.local.project.exam01;

import java.time.LocalDate;

// Данные о владельце: имя, фамилия, год рождения.
public class Visitor {
    private String firstName;
    private String lastName;
    private LocalDate yearOfBirth;


    public Visitor(String firstName, String lastName, LocalDate yearOfBirth) {
        setFirstName(firstName);
        setLastName(lastName);
        setYearOfBirth(yearOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || !Helper.isAlfa(firstName)) {
            throw new IllegalArgumentException("Ошибка при вводе имени гостя!" +
                    "\nПовторите ввод используя только буквы!");
        } else {
            this.firstName = firstName;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || !Helper.isAlfa(lastName)) {
            throw new IllegalArgumentException("Ошибка при вводе фамилии гостя!" +
                    "\nПовторите ввод используя только буквы!");
        } else {
            this.lastName = lastName;
        }
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        if(yearOfBirth == null || yearOfBirth.isBefore(LocalDate.now().minusYears(80))
                || yearOfBirth.isAfter(LocalDate.now().minusYears(18))){
            throw new IllegalArgumentException("Внимание, возрастное ограничение: Продажа абонемента осуществляется лицам от 18 до 80 лет");
        }
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Имя: " + getFirstName() + ", Фамилия: " + getLastName() + ", дата рождения: " + getYearOfBirth();
    }
}