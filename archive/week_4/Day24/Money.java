public class Money {
    int amount;

    public String name() {
        return "钱";
    }

    public void show() {
        System.out.println(name() + ": " + amount);
    }
}
