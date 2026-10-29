public class snack extends Goods {
    public snack(String name,double price) {
        super(name, price);
    }

    @Override
    public String kind() {
        return "零食";
    }
}
