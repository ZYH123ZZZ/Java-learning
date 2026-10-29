public class AnimalMain {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[4];
        zoo[0] = new Dog("小白", 2);
        zoo[1] = new Cat("咪咪", 3);
        zoo[2] = new Bird("小毛", 5);
        zoo[3] = new Cat("米亚", 6);

        for (Animal x : zoo) {
            x.eat();
            if (x instanceof Bird) {
                Bird b = (Bird) x;   //这一行不会写
                b.fly();
            }
        }
    }
}
