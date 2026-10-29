public class Cat extends Animal {
    public Cat(String name, int age) {//这里不能加String
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + " " + "吃鱼");
    }

    @Override
    public String kind() {
        return "猫";
    }
}
