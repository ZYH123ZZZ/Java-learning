public class Book1 {
    String name;
    double price;

    public void infoPrint() {
        System.out.printf("%s %.2f%n", name ,  price);
    }

    public Book1(String n, double pr) {
        name = n;
        price = pr;
    }
}
