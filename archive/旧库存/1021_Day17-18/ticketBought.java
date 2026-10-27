public class ticketBought {
    String name;
    double price;
    int page;

    public ticketBought(String nameNew, double priceNew, int pageNew) {
        name = nameNew;
        price = priceNew;
        page = pageNew;
    }

    public double sumPrice() {            //不熟悉 括号可以空
        return price * page;
    }
    public void allPrint() {
        System.out.printf("%s %d %.2f%n",name,page,sumPrice());
    }
}
