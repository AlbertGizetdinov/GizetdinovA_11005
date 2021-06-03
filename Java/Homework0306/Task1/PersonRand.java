package Homework0306.Task1;

import java.util.Random;

public class PersonRand {
    Random rand = new Random();

    public Person randPerson() {
        return new Person(randName(), randAge(), randCountry());
    }

    private String randName() {
        String name = "";
        for (int i = 0; i < 15; i++) {
            name += ((char) rand.nextInt(100));
        }
        return name;
    }

    private int randAge() {
        int age;
        age = rand.nextInt(100);
        return age;
    }

    private Countries randCountry() {
        Countries country;
        Countries[] countries = Countries.values();
        country = countries[rand.nextInt(countries.length)];
        return country;
    }
}
