class Person implements Comparable<Person>, Printable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name + "\nAge: " + age);
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.getName());
    }
}