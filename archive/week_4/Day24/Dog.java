public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }              //这三段不会写

    @Override
    public void eat() {
        System.out.println(name + " " + "啃骨头");
    }

    public void bark() {
        System.out.println("汪汪汪");
    }

    @Override
    public String kind() {
        return "狗";
    }
}
