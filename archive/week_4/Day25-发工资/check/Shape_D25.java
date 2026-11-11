public abstract class Shape_D25 {
    String name;

    public Shape_D25(String name) {
        this.name = name;
    }

    abstract double area();

    abstract double perimeter();

    public void show() {
        System.out.println(name + "面积= " + area() + " 周长= " + perimeter());
    }
}
