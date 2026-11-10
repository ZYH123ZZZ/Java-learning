public class Dog_D24 extends Animal_D24 {
    public Dog_D24(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(name + " 啃骨头");
    }

    @Override
    public void speak() {
        System.out.println(name + " 汪汪汪");
    }
}
