public class Duck_D25 extends Animal_D25 implements Swimmable_D25 {
    public Duck_D25(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " 嘎嘎嘎 ");
    }

    @Override
    public void swim() {
        System.out.println(name + " 在游泳");
    }
}
