package Homework0306.Task1;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private int age;
    private Countries country;

    public Person(String name, int age, Countries country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Countries getCountry() {
        return country;
    }
}
