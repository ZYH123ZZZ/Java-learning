public class Dog extends Animal {
    String breed;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " 在啃骨头");
    }

    public void bark() {
        System.out.println(name + "  汪汪汪");
    }

    @Override
    public String toString() {
        return name + " " + breed;
    }
}
