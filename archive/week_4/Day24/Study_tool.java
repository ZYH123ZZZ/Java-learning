public class Study_tool extends Goods {
    public Study_tool(String name, double price) {
        super(name, price);
    }

    @Override
    public String kind() {
        return "文具";
    }
}
