public class Goods {
    String name;
    double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String kind() {
        return "商品";
    }
}
