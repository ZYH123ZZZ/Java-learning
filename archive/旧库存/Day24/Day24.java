public class Day24 {
    public static void main(String[] args) {
        Animal[] a = new Animal[3];

        a[0] = new Dog("小白", 6);//忘记下标之间的区别和用法
        a[1] = new Cat("miew", 4);
        a[2] = new Dog("black", 7);//这一段不会写

        for (Animal x : a) {
            x.eat();
            if (x instanceof Dog) {
                Dog d = (Dog) x;       //不知道这个要写 以及忘记x后面加（Dog）
                d.bark();
            }
        }

    }
}
