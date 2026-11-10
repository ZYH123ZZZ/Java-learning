public class Dog_D23 extends Animal_D23 {
    public Dog_D23(String name) {
        super(name);
    }

    public void speak2() {
        System.out.println(name + " 汪汪");
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println(name + " 汪汪汪 ");
    }
}
