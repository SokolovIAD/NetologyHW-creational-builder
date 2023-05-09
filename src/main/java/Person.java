import java.util.Locale;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = null;
        this.address = null;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = null;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = city;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age != null) {
            return OptionalInt.of(age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age != null) {
            age += 1;
        }
    }

    public PersonBuilder newChildBuilder() {
        if(hasAddress()) {
            return new PersonBuilder().setSurname(surname).setAddress(address);
        } else {
            return new PersonBuilder().setSurname(surname);
        }
    }

    @Override
    public String toString() {
        return "\n" + name + " " + surname +
                "\n Возраст: " + age +
                "\n Город проживания: " + address + "\n";
    }
}
