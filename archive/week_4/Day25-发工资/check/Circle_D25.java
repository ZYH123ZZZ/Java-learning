public class Circle_D25 extends Shape_D25 implements Scalable_D25 {
    double r;

    public Circle_D25(String name, double r) {
        super(name);
        this.r = r;
    }

    @Override
    public double area() {
        return r * r * 3.14;
    }

    @Override
    public double perimeter() {
        return 2 * 3.14 * r;
    }

    @Override
    public void scale(double factore) {
        r = r * factore;
    }
}
