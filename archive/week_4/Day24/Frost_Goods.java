public class Frost_Goods extends Goods {
    public Frost_Goods(String name, double price) {
        super(name, price);
    }

    @Override
    public String kind() {
        return "冷冻";
    }
}
