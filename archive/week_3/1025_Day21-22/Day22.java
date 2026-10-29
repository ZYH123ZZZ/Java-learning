public class Day22 {
    public static void main(String[] args) {
        Dog d = new Dog("旺财");
        d.breed = "中华田园犬";
        d.eat();
        d.bark();
        Cat c = new Cat("咪咪");
        c.eat();
        c.miaow();
        System.out.println(c + " " + d);
    }
}
