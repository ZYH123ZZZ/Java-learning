public class Drink extends Goods {
    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String kind() {
        return "饮料";
    }
}
