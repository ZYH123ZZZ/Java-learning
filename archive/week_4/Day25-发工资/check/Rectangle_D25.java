public class Rectangle_D25 extends Shape_D25 implements Scalable_D25 {
    double w;
    double h;

    public Rectangle_D25(String name, double w, double h) {
        super(name);
        this.w = w;
        this.h = h;
    }

    @Override
    public double area() {
        return w * h;
    }

    @Override
    public double perimeter() {
        return (w + h) * 2;
    }

    @Override
    public void scale(double factore) {
        w = w * factore;
        h = h * factore;
    }
}
