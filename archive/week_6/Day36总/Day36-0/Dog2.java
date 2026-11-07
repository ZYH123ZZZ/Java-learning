import java.util.Objects;

public class Dog2 {
    String name;
    int age;

    public Dog2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dog2)) {
            return false;
        }
        Dog2 d = (Dog2) o;
        return d.age == age && Objects.equals(name, d.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Dog2{name= " + name + ", age= " + age + "}";
    }
}
