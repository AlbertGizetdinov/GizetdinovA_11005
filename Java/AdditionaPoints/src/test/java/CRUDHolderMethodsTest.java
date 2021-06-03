import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class CRUDHolderMethodsTest {
    private CRUDHolder<Person> persons;

    @Before
    public void preparePersons() {
        persons = new CRUDHolder<Person>();
        persons.items.add(new Person("Rick", 70));
        persons.items.add(new Person("Morty", 7));
    }

    @Test
    public void createPersonsTestSucceed() {
        persons.create(new Person("Mike", Integer.MAX_VALUE));
        assertEquals("Mike", persons.items.get(2).getName());
        assertEquals(Integer.MAX_VALUE, persons.items.get(2).getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPersonsTestFailed() {
        persons.create(new Person("Rick", 70));
    }

    @Test
    public void readPersonsTestSucceed() {
        Person person = persons.read(1);
        assertEquals(persons.items.get(1), person);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readPersonsTestFailed() {
        Person person = persons.read(18);
    }

    @Test
    public void updatePersonsTestSucceed() {
        persons.update(new Person("Morty", 20));
        assertEquals("Morty", persons.items.get(1).name);
        assertEquals(20, persons.items.get(1).age);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updatePersonsTestFailed() {
        persons.update(new Person("Bob", Integer.MAX_VALUE));
    }

    @Test
    public void deletePersonsTestSucceed() {
        persons.delete(persons.items.get(0));
        assertEquals(1, persons.items.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void deletePersonsTestFailed() {
        persons.delete(new Person("Travis", Integer.MAX_VALUE));
    }
}
