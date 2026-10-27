public class MoneyMain {
    public static void main(String[] args) {
        Money[] m = new Money[3];
        m[0] = new Cash();
        m[0].amount = 100;
        m[1] = new Cash();
        m[1].amount = 50;
        m[2] = new Coin();
        m[2].amount = 5;

        for (Money x : m) {
            x.show();
        }
    }
}
