public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void miaow() {
        System.out.println(name + " 喵喵喵");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("(还舔了舔爪子)");
    }

    @Override
    public String toString() {
        return name;
    }
}
