import java.util.Objects;

public class Dog1 {
    String name;
    int age;

    public Dog1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dog1)) {
            return false;
        }
        Dog1 d = (Dog1) o;
        return age == d.age && Objects.equals(name, d.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
