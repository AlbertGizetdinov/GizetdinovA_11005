package Homework0306.Task1;

import java.io.*;

public class SerializeAndDeserialize implements Runnable {
    int action;

    public SerializeAndDeserialize(String a) {
        if (a.equals("writer")) action = 1;
        if (a.equals("reader")) action = 2;
    }

    public void serialize(PersonRand p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            oos.writeObject(p.randPerson());
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void deserialize() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person p = (Person)ois.readObject();
            System.out.println("Name: " + p.getName() + ", age: " + p.getAge() + ", country: " + p.getCountry());
        }
        catch(Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void run() {
        if (action == 1) {
            serialize(new PersonRand());
        }

        if (action == 2) {
            deserialize();
        }
    }
}
