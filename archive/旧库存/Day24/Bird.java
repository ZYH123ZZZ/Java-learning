public class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + " 啄米");
    }

    public void fly() {
        System.out.println(name + " 飞走了");
    }

    @Override
    public String kind() {
        return "鸟";
    }
}
